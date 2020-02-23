package com.inretailpharma.digital.ordermanager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class ServiceLocalOrderIdentity implements Serializable {

    public ServiceLocalOrderIdentity() {

    }

    public ServiceLocalOrderIdentity(ServiceType serviceType, Local local, OrderFulfillment orderFulfillment, OrderStatus orderStatus) {
        this.serviceType = serviceType;
        this.local = local;
        this.orderFulfillment = orderFulfillment;
        this.orderStatus = orderStatus;
    }


    /*
    @Column(name="service_type_code")
    private String serviceTypeCode;

    @Column(name="local_code")
    private String localCode;

    @Column(name="order_fulfillment_id")
    private Long orderTrackerId;

    @Column(name="order_status_code")
    private String orderStatusCode;

    public ServiceLocalOrderIdentity(String serviceTypeCode, String localCode, Long orderTrackerId, String orderStatusCode) {
        this.serviceTypeCode = serviceTypeCode;
        this.localCode = localCode;
        this.orderTrackerId = orderTrackerId;
        this.orderStatusCode = orderStatusCode;
    }

     */



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="service_type_code",referencedColumnName = "code")
    private ServiceType serviceType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="local_code",referencedColumnName = "code")
    private Local local;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_fulfillment_id",referencedColumnName = "id")
    private OrderFulfillment orderFulfillment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_status_code",referencedColumnName = "code")
    private OrderStatus orderStatus;
}
