package com.inretailpharma.digital.ordermanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class PaymentMethodDto {

    private String type;
    private String cardProvider;
    private BigDecimal paidAmount;
    private BigDecimal changeAmount;
}
