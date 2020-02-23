package com.inretailpharma.digital.ordermanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class OrderStatusDto {

    private String code;
    private String description;

}
