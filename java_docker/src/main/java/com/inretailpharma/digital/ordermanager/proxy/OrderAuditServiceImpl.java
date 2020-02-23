package com.inretailpharma.digital.ordermanager.proxy;

import com.inretailpharma.digital.ordermanager.canonical.OrderFulfillmentCanonical;
import com.inretailpharma.digital.ordermanager.canonical.management.OrderResultCanonical;
import com.inretailpharma.digital.ordermanager.config.parameters.ExternalServicesProperties;
import com.inretailpharma.digital.ordermanager.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
public class OrderAuditServiceImpl implements OrderExternalService {


    private final ExternalServicesProperties externalServicesProperties;

    public OrderAuditServiceImpl(ExternalServicesProperties externalServicesProperties) {
        this.externalServicesProperties = externalServicesProperties;
    }


    @Override
    public void sendOrder(OrderFulfillmentCanonical orderAuditCanonical) {
        log.info("[START] connect api audit..  - value:{} - body:{}",
                externalServicesProperties, orderAuditCanonical);

        Flux<String> response = WebClient.create(externalServicesProperties.getUriApiService())
                .post().bodyValue(orderAuditCanonical).retrieve().bodyToFlux(String.class);
        response.subscribe(log::info);
        log.info("Exiting NON-BLOCKING Service!");
    }

    @Override
    public OrderResultCanonical getResultfromExternalServices(Long ecommerceId, Constant.ActionOrder actionOrder) {
        return null;
    }


    private ClientHttpRequestFactory getClientHttpRequestFactory() {

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(1000);

        return clientHttpRequestFactory;
    }

}
