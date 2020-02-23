package com.inretailpharma.digital.ordermanager.canonical.management;

import lombok.Data;

@Data
public class OrderResultCanonical {
    private Long trackerId;
    private Long externalId;
    private String statusCode;
    private String status;
    private String statusDescription;
    private String statusDetail;
    private Integer attempt;
    private Integer attemptTracker;
}
