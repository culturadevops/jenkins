package com.inretailpharma.digital.ordermanager.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "company")
public class Company implements Serializable {

    @Id
    private String code;
    private String name;
}
