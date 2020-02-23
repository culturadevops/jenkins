package com.inretailpharma.digital.ordermanager.service.impl;

import com.inretailpharma.digital.ordermanager.dto.OrderDto;
import com.inretailpharma.digital.ordermanager.entity.*;
import com.inretailpharma.digital.ordermanager.entity.projection.IOrderFulfillment;
import com.inretailpharma.digital.ordermanager.repository.*;
import com.inretailpharma.digital.ordermanager.service.OrderRepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;


@Slf4j
@Service
public class OrderRepositoryServiceImpl implements OrderRepositoryService {

    private OrderRepository orderRepository;
    private ServiceTypeRepository serviceTypeRepository;
    private LocalRepository localRepository;
    private OrderStatusRepository orderStatusRepository;
    private ServiceLocalOrderRepository serviceLocalOrderRepository;

    public OrderRepositoryServiceImpl(OrderRepository orderRepository,
                                      ServiceTypeRepository serviceTypeRepository,
                                      LocalRepository localRepository,
                                      OrderStatusRepository orderStatusRepository,
                                      ServiceLocalOrderRepository serviceLocalOrderRepository) {
        this.orderRepository = orderRepository;
        this.serviceTypeRepository = serviceTypeRepository;
        this.localRepository = localRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.serviceLocalOrderRepository = serviceLocalOrderRepository;
    }

    @Override
    public OrderFulfillment createOrder(OrderFulfillment orderFulfillment, OrderDto orderDto) {
        log.info("[START] create repository service");
        return orderRepository.save(orderFulfillment);
    }

    @Override
    public ServiceType getServiceTypeByCode(String code) {
        return serviceTypeRepository.getOne(code);
    }

    @Override
    public Local getLocalByCode(String localCode) {
        return localRepository.getOne(localCode);
    }

    @Override
    public OrderStatus getOrderStatusByCode(String code) {
        return orderStatusRepository.getOne(code);
    }

    //@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.READ_COMMITTED)
    @Override
    public ServiceLocalOrder saveServiceLocalOrder(ServiceLocalOrder serviceLocalOrder) {
        return serviceLocalOrderRepository.save(serviceLocalOrder);
    }

    @Override
    public List<IOrderFulfillment> getListOrdersByStatus(Set<String> status) {
        return orderRepository.getListOrdersByStatus(status);
    }

    @Override
    public IOrderFulfillment getOrderByecommerceId(Long ecommerceId) {
        return orderRepository.getOrderByecommerceId(ecommerceId);
    }

    @Override
    public void updateReattemtpInsink(Long orderFulfillmentId, Integer attempt,
                                      String orderStatusCode, String statusDetail) {
        serviceLocalOrderRepository.updateReattemtpInsink(orderFulfillmentId, attempt,
                orderStatusCode, statusDetail);
    }

    @Override
    public void updateRetryingOrderStatusProcess(Long orderFulfillmentId, Integer attemptTracker,
                                          Integer attempt, String orderStatusCode, String statusDetail) {
        serviceLocalOrderRepository.updateRetryingOrderStatusProcess(orderFulfillmentId, attemptTracker, attempt,
                orderStatusCode, statusDetail);
    }

    @Override
    public void updateReattemtpTracker(Long orderFulfillmentId, Integer attemptTracker,
                                       String orderStatusCode, String statusDetail) {
        serviceLocalOrderRepository.updateReattemtpTracker(orderFulfillmentId, attemptTracker,
                orderStatusCode, statusDetail);
    }

    @Override
    public void updateExternalPurchaseId(Long orderFulfillmentId, Long externalPurchaseId) {
        orderRepository.updateExternalPurchaseId(orderFulfillmentId, externalPurchaseId);
    }

    @Override
    public void updateTrackerId(Long orderFulfillmentId, Long trackerId) {
        orderRepository.updateTrackerId(orderFulfillmentId, trackerId);
    }

    @Override
    public void updateExternalAndTrackerId(Long orderFulfillmentId, Long externalPurchaseId,
                                                     Long ecommerceId) {
        orderRepository.updateExternalAndTrackerId(orderFulfillmentId, externalPurchaseId, ecommerceId);
    }

}
