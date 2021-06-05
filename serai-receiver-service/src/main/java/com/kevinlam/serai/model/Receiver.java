package com.kevinlam.serai.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Receiver {
    private String id;
    private BigDecimal message;
    private Timestamp createDateTime;
    private Timestamp updatedDateTime;
}
