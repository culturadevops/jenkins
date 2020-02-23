package com.inretailpharma.digital.ordermanager.canonical;

import lombok.Data;

@Data
public class PaymentMethodCanonical {

    private String type;
    private String providerCard;
}
