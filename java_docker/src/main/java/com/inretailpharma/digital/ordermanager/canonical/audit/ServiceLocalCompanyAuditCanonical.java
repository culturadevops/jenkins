package com.inretailpharma.digital.ordermanager.canonical.audit;

import lombok.Data;

@Data
public class ServiceLocalCompanyAuditCanonical {

    private String serviceType;
    private String localCode;
    private String local;
    private String company;
}
