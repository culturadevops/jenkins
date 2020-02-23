package com.inretailpharma.digital.ordermanager.service;

import com.inretailpharma.digital.ordermanager.dto.OrderDto;
import com.inretailpharma.digital.ordermanager.entity.*;
import com.inretailpharma.digital.ordermanager.entity.projection.IOrderFulfillment;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface OrderRepositoryService {

    OrderFulfillment createOrder(OrderFulfillment orderFulfillment, OrderDto orderDto);
    ServiceType getServiceTypeByCode(String code);
    Local getLocalByCode(String code);
    OrderStatus getOrderStatusByCode(String code);
    ServiceLocalOrder saveServiceLocalOrder(ServiceLocalOrder serviceLocalOrder);
    List<IOrderFulfillment> getListOrdersByStatus(Set<String> status);
    IOrderFulfillment getOrderByecommerceId(Long ecommerceId);
    void updateReattemtpInsink(Long orderFulfillmentId, Integer attempt,
                               String orderStatusCode, String statusDetail);
    void updateRetryingOrderStatusProcess(Long orderFulfillmentId, Integer attemptTracker,
                                   Integer attempt, String orderStatusCode, String statusDetail);
    void updateReattemtpTracker(Long orderFulfillmentId, Integer attemptTracker,
                               String orderStatusCode, String statusDetail);
    void updateExternalPurchaseId(Long orderFulfillmentId, Long externalPurchaseId);
    void updateTrackerId(Long orderFulfillmentId, Long trackerId);
    void updateExternalAndTrackerId(Long orderFulfillmentId, Long externalPurchaseId, Long trackerId);
}
