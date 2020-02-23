package com.inretailpharma.digital.ordermanager.entity;

import lombok.Data;
import org.apache.commons.lang3.EnumUtils;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Embeddable
@Table(name="payment_method")
public class PaymentMethod {

    @Enumerated(EnumType.STRING)
    @Column(table = "payment_method", name="payment_type")
    private PaymentType paymentType;

    @Column(table = "payment_method", name="card_provider")
    private String cardProvider;

    @Column(table = "payment_method", name="card_name")
    private String cardName;

    @Column(table = "payment_method", name="card_number")
    private String cardNumber;

    @Column(table = "payment_method", name="paid_amount")
    private BigDecimal paidAmount;

    @Column(table = "payment_method", name="change_amount")
    private BigDecimal changeAmount;

    @Column(table = "payment_method", name="payment_note")
    private String paymentNote;

    public enum PaymentType {

        CASH("CASH"), CASH_DOLAR("CASH_DOLAR"), CARD("POS"), ONLINE_PAYMENT("ONLINE");

        private final String kit;

        PaymentType(String kit) {
            this.kit = kit;
        }

        public String kit() {
            return kit;
        }

        public static PaymentType getPaymentTypeByNameType(String type) {
            return EnumUtils.getEnumList(PaymentType.class)
                    .stream()
                    .filter(item -> item.name().equalsIgnoreCase(type))
                    .findFirst()
                    .orElse(CASH);
        }

    }
}
