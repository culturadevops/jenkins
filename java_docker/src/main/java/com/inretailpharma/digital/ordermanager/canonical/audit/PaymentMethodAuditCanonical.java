package com.inretailpharma.digital.ordermanager.canonical.audit;

import lombok.Data;

@Data
public class PaymentMethodAuditCanonical {

    private String type;
    private String providerCard;

}
