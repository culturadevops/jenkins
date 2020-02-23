package com.inretailpharma.digital.ordermanager.proxy;

import com.inretailpharma.digital.ordermanager.canonical.OrderFulfillmentCanonical;
import com.inretailpharma.digital.ordermanager.canonical.management.OrderResultCanonical;
import com.inretailpharma.digital.ordermanager.util.Constant;

public interface OrderExternalService {

    void sendOrder(OrderFulfillmentCanonical orderAuditCanonical);
    OrderResultCanonical getResultfromExternalServices(Long ecommerceId, Constant.ActionOrder actionOrder);

}
