package com.inretailpharma.digital.ordermanager.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.inretailpharma.digital.ordermanager.util.Constant;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class OrderDto {

    private Long id;
    private String source;
    private String serviceTypeCode;
    private String localCode;

    private Long ecommercePurchaseId;
    private Long trackerId;
    private Long externalPurchaseId;
    private Long bridgePurchaseId;
    private OrderStatusDto orderStatusDto;
    private BigDecimal deliveryCost;
    private BigDecimal totalCost;

    private ClientDto client;

    private AddressDto address;

    private String createdOrder;
    private String scheduledTime;

    private String notes;

    private ShipperDto shipper;

    private PaymentMethodDto payment;

    private ReceiptTypeDto receipt;

    private List<OrderDetailDto> orderItem;

    private Boolean programmed;

    private Constant.ActionOrder action;


}
