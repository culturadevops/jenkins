package com.inretailpharma.digital.ordermanager.proxy;

import com.inretailpharma.digital.ordermanager.canonical.OrderFulfillmentCanonical;
import com.inretailpharma.digital.ordermanager.canonical.management.OrderResultCanonical;
import com.inretailpharma.digital.ordermanager.config.parameters.ExternalServicesProperties;
import com.inretailpharma.digital.ordermanager.util.Constant;
import org.springframework.stereotype.Service;

@Service("auditProxy")
public class OrderAuditProxy implements OrderExternalService {

    private ExternalServicesProperties externalServicesProperties;

    private static OrderExternalService orderExternalService;

    public OrderAuditProxy(ExternalServicesProperties externalServicesProperties) {
        this.externalServicesProperties = externalServicesProperties;
    }

    @Override
    public void sendOrder(OrderFulfillmentCanonical orderAuditCanonical) {

        if (orderExternalService == null) {
            orderExternalService = new OrderAuditServiceImpl(externalServicesProperties);
        }

        orderExternalService.sendOrder(orderAuditCanonical);

    }

    @Override
    public OrderResultCanonical getResultfromExternalServices(Long ecommerceId, Constant.ActionOrder actionOrder) {
        return null;
    }

}
