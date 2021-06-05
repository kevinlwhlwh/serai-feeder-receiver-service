package com.kevinlam.serai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "RECEIVER_DATA_TABLE")
public class ReceiverEntity implements Serializable {
    @Id
    @Column(name = "RECORD_ID")
    private String id;

    @Column(name = "MESSAGE")
    private BigDecimal message;

    @Column(name = "CREATE_DATETIME")
    private Timestamp createDateTime;

    @Column(name = "UPDATE_DATETIME")
    private Timestamp updatedDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getMessage() {
        return message;
    }

    public void setMessage(BigDecimal message) {
        this.message = message;
    }

    public Timestamp getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Timestamp createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Timestamp getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Timestamp updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
