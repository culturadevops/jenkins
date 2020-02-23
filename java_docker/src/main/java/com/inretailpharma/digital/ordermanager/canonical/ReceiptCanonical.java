package com.inretailpharma.digital.ordermanager.canonical;

import lombok.Data;

@Data
public class ReceiptCanonical {

    private String type;
    private String ruc;
    private String companyName;
    private String address;
}
