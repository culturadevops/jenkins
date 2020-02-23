package com.inretailpharma.digital.ordermanager.canonical.audit;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddressAuditCanonical {

    private String department;
    private String province;
    private String district;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String name;
}
