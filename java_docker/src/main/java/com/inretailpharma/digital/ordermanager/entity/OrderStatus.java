package com.inretailpharma.digital.ordermanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name="order_status")
public class OrderStatus implements Serializable {

    @Id
    private String code;
    private String type;
    private String description;

}
