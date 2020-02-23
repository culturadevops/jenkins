package com.inretailpharma.digital.ordermanager.proxy;

import com.inretailpharma.digital.ordermanager.canonical.OrderFulfillmentCanonical;
import com.inretailpharma.digital.ordermanager.canonical.dispatcher.InsinkResponseCanonical;
import com.inretailpharma.digital.ordermanager.canonical.dispatcher.TrackerInsinkResponseCanonical;
import com.inretailpharma.digital.ordermanager.canonical.dispatcher.TrackerResponseDto;
import com.inretailpharma.digital.ordermanager.canonical.management.OrderResultCanonical;
import com.inretailpharma.digital.ordermanager.config.parameters.ExternalServicesProperties;
import com.inretailpharma.digital.ordermanager.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service("deliveryDispatcher")
public class DeliveryDispatcherServiceImpl implements OrderExternalService{

    private ExternalServicesProperties externalServicesProperties;

    private RestTemplate restTemplate;

    public DeliveryDispatcherServiceImpl(ExternalServicesProperties externalServicesProperties,
                                         @Qualifier("dispatcherRestTemplate") RestTemplate restTemplate) {
        this.externalServicesProperties = externalServicesProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendOrder(OrderFulfillmentCanonical orderAuditCanonical) {

    }

    @Override
    public OrderResultCanonical getResultfromExternalServices(Long ecommerceId, Constant.ActionOrder actionOrder) {
        log.info("update order actionOrder.getCode:{}", actionOrder.getCode());

        OrderResultCanonical orderResultCanonical;

        switch (actionOrder.getCode()) {
            case 1:
                // reattempt to send delivery dispatcher at inkatracker or inkatrackerlite
                TrackerResponseDto trackerResponseDto = null;

                try {
                    log.info("Starting Connect Dispatcher uri action id 1: {}",
                            externalServicesProperties.getDispatcherTrackerUri().replace("{ecommerceId}", ecommerceId.toString()));

                    trackerResponseDto =
                            restTemplate.getForEntity(
                                    externalServicesProperties.getDispatcherTrackerUri().replace("{ecommerceId}", ecommerceId.toString()),
                                    TrackerResponseDto.class).getBody();

                    log.info("End Connect Dispatcher uri action id 1 with response - {}",trackerResponseDto);

                    orderResultCanonical = Optional
                                                .ofNullable(trackerResponseDto)
                                                .map(r -> {
                                                    OrderResultCanonical resultCanonical = new OrderResultCanonical();

                                                    resultCanonical.setTrackerId(r.getId());
                                                    resultCanonical.setStatusDetail(r.getDetail());

                                                    Constant.OrderStatus orderStatus = Optional.ofNullable(r.getId())
                                                            .map(s -> Constant.OrderStatus.FULFILLMENT_PROCESS_SUCCESS)
                                                            .orElse(Constant.OrderStatus.ERROR_INSERT_TRACKER);

                                                    resultCanonical.setStatusCode(orderStatus.getCode());
                                                    resultCanonical.setStatusDescription(orderStatus.name());
                                                    return resultCanonical;
                                                }).orElseGet(() -> {
                                                    OrderResultCanonical resultCanonical = new OrderResultCanonical();
                                                    resultCanonical.setStatusCode(Constant.OrderStatus.NOT_DEFINED_ERROR.getCode());
                                                    resultCanonical.setStatus(Constant.OrderStatus.NOT_DEFINED_ERROR.name());

                                                    return resultCanonical;
                                                });
                } catch (RestClientException e) {
                    String errorMessage = "Connection Error with DD: " +
                            "Error invoking '" +
                            externalServicesProperties.getDispatcherTrackerUri() + "':" + e.getMessage();
                    log.error(errorMessage);
                    orderResultCanonical = new OrderResultCanonical();
                    orderResultCanonical.setStatusCode(Constant.OrderStatus.ERROR_INSERT_TRACKER.getCode());
                    orderResultCanonical.setStatus(Constant.OrderStatus.ERROR_INSERT_TRACKER.name());
                    orderResultCanonical.setStatusDetail(errorMessage);

                    //TODO check boolean used
                } catch (Exception e) {
                    e.printStackTrace();
                    String errorMessage = "General Error invoking '" + externalServicesProperties.getDispatcherTrackerUri() +
                            "':" + e.getMessage();
                    log.error(errorMessage);
                    orderResultCanonical = new OrderResultCanonical();
                    orderResultCanonical.setStatusCode(Constant.OrderStatus.ERROR_INSERT_TRACKER.getCode());
                    orderResultCanonical.setStatus(Constant.OrderStatus.ERROR_INSERT_TRACKER.name());
                    orderResultCanonical.setStatusDetail(errorMessage);
                }

                break;

            case 2:
                // reattempt to send delivery dispatcher at insink
                TrackerInsinkResponseCanonical trackerInsinkResponseCanonical;
                try {
                    log.info("Starting Connect Dispatcher uri action id 2: {}",
                            externalServicesProperties.getDispatcherInsinkTrackerUri().replace("{ecommerceId}", ecommerceId.toString()));

                    trackerInsinkResponseCanonical =
                            restTemplate
                                    .getForEntity(
                                            externalServicesProperties.getDispatcherInsinkTrackerUri().replace("{ecommerceId}", ecommerceId.toString()),
                                            TrackerInsinkResponseCanonical.class
                                    ).getBody();

                    log.info("End Connect Dispatcher uri action id 2 with response - {}",trackerInsinkResponseCanonical);

                    orderResultCanonical = Optional
                                                .ofNullable(trackerInsinkResponseCanonical)
                                                .filter(r -> (r.getInsinkProcess() != null && r.getTrackerProcess() != null))
                                                .map(r -> {
                                                    OrderResultCanonical resultCanonical = new OrderResultCanonical();

                                                    if (r.getTrackerProcess() && r.getInsinkProcess()) {

                                                        resultCanonical.setTrackerId(r.getTrackerResponseDto().getId());
                                                        resultCanonical.setExternalId(
                                                                Optional
                                                                        .ofNullable(r.getInsinkResponseCanonical().getInkaventaId())
                                                                        .map(Long::parseLong).orElse(null)
                                                        );

                                                        Constant.OrderStatus orderStatus = Optional.ofNullable(r.getInsinkResponseCanonical().getSuccessCode())
                                                                .filter(t -> t.equalsIgnoreCase("0-1") && resultCanonical.getExternalId() == null)
                                                                .map(t -> Constant.OrderStatus.SUCCESS_RESERVED_ORDER)
                                                                .orElse(Constant.OrderStatus.FULFILLMENT_PROCESS_SUCCESS);

                                                        resultCanonical.setStatusCode(orderStatus.getCode());
                                                        resultCanonical.setStatusDescription(orderStatus.name());

                                                    } else if (r.getInsinkProcess() && !r.getTrackerProcess()) {
                                                        resultCanonical.setExternalId(
                                                                Optional
                                                                        .ofNullable(r.getInsinkResponseCanonical().getInkaventaId())
                                                                        .map(Long::parseLong).orElse(null)
                                                        );
                                                        resultCanonical.setStatusCode(Constant.OrderStatus.ERROR_INSERT_TRACKER.getCode());
                                                        resultCanonical.setStatus(Constant.OrderStatus.ERROR_INSERT_TRACKER.name());
                                                        resultCanonical.setStatusDetail(r.getTrackerResponseDto().getDetail());
                                                    } else {
                                                        resultCanonical.setStatusCode(Constant.OrderStatus.ERROR_INSERT_INKAVENTA.getCode());
                                                        resultCanonical.setStatus(Constant.OrderStatus.ERROR_INSERT_INKAVENTA.name());
                                                        resultCanonical.setStatusDetail(r.getInsinkResponseCanonical().getMessageDetail());
                                                    }

                                                    return resultCanonical;
                                                }).orElseGet(() -> {
                                                    OrderResultCanonical resultCanonical = new OrderResultCanonical();
                                                    resultCanonical.setStatusCode(Constant.OrderStatus.NOT_DEFINED_ERROR.getCode());
                                                    resultCanonical.setStatus(Constant.OrderStatus.NOT_DEFINED_ERROR.name());
                                                    return resultCanonical;
                                                });

                } catch (RestClientException e) {
                    String errorMessage = "Connection Error with DD: " +
                            "Error invoking '" +
                            externalServicesProperties.getDispatcherInsinkTrackerUri() + "':" + e.getMessage();
                    log.error(errorMessage);

                    orderResultCanonical = new OrderResultCanonical();
                    orderResultCanonical.setStatusCode(Constant.OrderStatus.ERROR_INSERT_INKAVENTA.getCode());
                    orderResultCanonical.setStatus(Constant.OrderStatus.ERROR_INSERT_INKAVENTA.name());
                    orderResultCanonical.setStatusDetail(errorMessage);
                    //TODO check boolean used
                } catch (Exception e) {
                    e.printStackTrace();
                    String errorMessage = "General Error invoking '" + externalServicesProperties.getDispatcherInsinkTrackerUri() +
                            "':" + e.getMessage();
                    log.error(errorMessage);
                    orderResultCanonical = new OrderResultCanonical();
                    orderResultCanonical.setStatusCode(Constant.OrderStatus.ERROR_INSERT_INKAVENTA.getCode());
                    orderResultCanonical.setStatus(Constant.OrderStatus.ERROR_INSERT_INKAVENTA.name());
                    orderResultCanonical.setStatusDetail(errorMessage);
                }

                break;

            default:
                orderResultCanonical = new OrderResultCanonical();
                orderResultCanonical.setStatusCode(Constant.OrderStatus.NOT_FOUND_ACTION.getCode());
                orderResultCanonical.setStatus(Constant.OrderStatus.NOT_FOUND_ACTION.name());
                break;
        }

        log.info("object parse order result {}", orderResultCanonical);

        return orderResultCanonical;
    }

}
