package com.inretailpharma.digital.ordermanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ReceiptTypeDto {

    private String name;
    private String documentNumber;
    private String ruc;
    private String companyName;
    private String companyAddress;
    private String note;
}
