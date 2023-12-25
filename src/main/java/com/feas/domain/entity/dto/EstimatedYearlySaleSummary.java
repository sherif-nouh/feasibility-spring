package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ١١/٠٧/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstimatedYearlySaleSummary {

    private BigDecimal sumTotalPrice;
    private BigDecimal sumTotalUnitePrice;
    private BigDecimal sumTotalQuantity;
}
