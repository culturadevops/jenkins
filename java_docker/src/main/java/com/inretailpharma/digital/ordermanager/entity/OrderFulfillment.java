package com.inretailpharma.digital.ordermanager.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase OrderFulfillment subdominio order tracker
 *
 * @author
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="order_fulfillment")
@SecondaryTables({
        @SecondaryTable(name="payment_method", pkJoinColumns = @PrimaryKeyJoinColumn(name = "order_fulfillment_id", referencedColumnName = "id")),
        @SecondaryTable(name="receipt_type", pkJoinColumns = @PrimaryKeyJoinColumn(name = "order_fulfillment_id", referencedColumnName = "id"))
})
public class OrderFulfillment extends OrderEntity<Long> {

    private String source;

    @Column(name="ecommerce_purchase_id")
    private Long ecommercePurchaseId;

    @Column(name="tracker_id")
    private Long trackerId;

    @Column(name="external_purchase_id")
    private Long externalPurchaseId;

    @Column(name="bridge_purchase_id")
    private Long bridgePurchaseId;

    @Column(name="delivery_cost")
    private BigDecimal deliveryCost;

    @Column(name="total_cost")
    private BigDecimal totalCost;

    @Column(name="created_order")
    private LocalDateTime createdOrder;

    @Column(name="scheduled_time")
    private LocalDateTime scheduledTime;

    @Column(name="document_number")
    private String documentNumber;

    private String notes;

    @Embedded
    private PaymentMethod paymentMethod;

    @Embedded
    private ReceiptType receiptType;

    @ElementCollection
    @CollectionTable(name = "order_fulfillment_item", joinColumns = @JoinColumn(name = "order_fulfillment_id"))
    private List<OrderFulfillmentItem> orderItem;

}