package com.inretailpharma.digital.ordermanager.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Data
@Embeddable
@Table(name="receipt_type")
public class ReceiptType {

    @Column(table = "receipt_type")
    private String name;

    @Column(table = "receipt_type",name="document_number")
    private String documentNumber;

    @Column(table = "receipt_type")
    private String ruc;

    @Column(table = "receipt_type", name="company_name")
    private String companyName;

    @Column(table = "receipt_type", name="company_address")
    private String companyAddress;

    @Column(table = "receipt_type", name="receipt_note")
    private String receiptNote;
}
