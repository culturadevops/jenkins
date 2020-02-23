package com.inretailpharma.digital.ordermanager.canonical.audit;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderAuditCanonical {

    private String trackerCode;
    private String ecommerceCode;
    private String externalCode;
    private String clientFullName;
    private String documentNumber;
    private String leadTime;
    private BigDecimal totalAmount;
    private ServiceLocalCompanyAuditCanonical serviceLocalCompany;
    private OrderStatusAuditCanonical orderStatus;
    private ReceiptAuditCanonical receipt;
    private PaymentMethodAuditCanonical paymentMethod;
    private AddressAuditCanonical addressDelivery;


}
