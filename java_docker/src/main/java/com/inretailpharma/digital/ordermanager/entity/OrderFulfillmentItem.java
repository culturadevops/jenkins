package com.inretailpharma.digital.ordermanager.entity;

import com.inretailpharma.digital.ordermanager.util.Constant;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Embeddable
@Table(name="order_fulfillment_item")
public class OrderFulfillmentItem {

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_sap_code")
    private String productSapCode;

    @Column(name = "name")
    private String productName;

    @Column(name = "short_description")
    private String shortDescription;
    private String brand;
    private Integer quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private Constant.Logical fractionated;

}
