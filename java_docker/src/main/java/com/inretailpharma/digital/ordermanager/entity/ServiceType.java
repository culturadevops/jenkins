package com.inretailpharma.digital.ordermanager.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    private String code;
    private String name;
    private String description;

}
