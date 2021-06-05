package com.kevinlam.serai.sender.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Receiver {
    private String id;
    private BigDecimal message;
    private Timestamp createDateTime;
    private Timestamp updatedDateTime;
}
