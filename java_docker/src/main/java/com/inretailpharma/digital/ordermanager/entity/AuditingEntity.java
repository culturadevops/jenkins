package com.inretailpharma.digital.ordermanager.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
@SuppressWarnings("all")
@EntityListeners({AuditingEntityListener.class})
public abstract class AuditingEntity implements Serializable {

    /** Actor who created an instance of the entity class */
    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    /** When the entity class was created */
    @CreatedDate
    @Column(name = "date_created")
    private Date createdDate;

    /** Actor who last updated an instance of the entity class */
    @LastModifiedBy
    @Column(name = "last_updated_by")
    private String lastModifiedBy;

    /** Indicates when was the last date the entity class was changed */
    @LastModifiedDate
    @Column(name = "date_last_updated")
    private Date lastModifiedDate;

    /** Determines the number of times an entity class has changed over time */
    @Version
    private Integer version;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "{\"AuditingEntity\":{"
            + "\"createdBy\":\"" + createdBy + "\""
            + ", \"createdDate\":" + createdDate
            + ", \"lastModifiedBy\":\"" + lastModifiedBy + "\""
            + ", \"lastModifiedDate\":" + lastModifiedDate
            + ", \"version\":\"" + version + "\""
            + "}}";
    }
}
