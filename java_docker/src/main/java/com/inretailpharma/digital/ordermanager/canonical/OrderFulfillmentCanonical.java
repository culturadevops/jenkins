package com.inretailpharma.digital.ordermanager.canonical;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderFulfillmentCanonical implements Serializable {

    // Canonical data order
    private Long id;
    private Long ecommerceId;
    private Long trackerId;
    private Long externalId;
    private String clientFullName;
    private String documentNumber;
    private String leadTime;
    private BigDecimal totalAmount;
    private Integer attempt;
    private Integer attemptTracker;

    // Canonical serviceType
    private ServiceTypeCanonical serviceType;

    // Canonical local and company
    private String localCode;
    private String local;
    private String company;

    // Canonical status
    private OrderStatusCanonical orderStatus;


    // Canonical receipt
    private ReceiptCanonical receipt;

    // Canonical PaymentMethod;
    private PaymentMethodCanonical paymentMethod;

    // Canonical Address delivery
    private AddressDeliveryCanonical  addressDelivery;



}
