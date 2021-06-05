package com.kevinlam.serai.sender.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Feeder implements Serializable {
    private BigDecimal message;
}
