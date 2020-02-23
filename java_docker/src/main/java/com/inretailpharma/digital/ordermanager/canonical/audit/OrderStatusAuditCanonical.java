package com.inretailpharma.digital.ordermanager.canonical.audit;

import lombok.Data;

@Data
public class OrderStatusAuditCanonical {

    private String status;
    private String statusCode;
    private String statusDetail;

}
