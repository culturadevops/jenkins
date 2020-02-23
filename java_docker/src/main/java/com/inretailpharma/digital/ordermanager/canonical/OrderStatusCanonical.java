package com.inretailpharma.digital.ordermanager.canonical;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderStatusCanonical implements Serializable {

    private String status;
    private String statusCode;
    private String statusDetail;

}
