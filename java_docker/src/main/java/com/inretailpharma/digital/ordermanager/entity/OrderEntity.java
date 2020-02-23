package com.inretailpharma.digital.ordermanager.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@MappedSuperclass
@SuppressWarnings("all")
public abstract class OrderEntity<T extends Serializable> extends AuditingEntity {

    /**
     * Unique reference for this entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{\"OrderEntity\":{"
            + "\"id\":" + id
            + "}}";
    }
}
