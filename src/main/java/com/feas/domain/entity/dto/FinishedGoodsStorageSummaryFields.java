package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٩/٠٢/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FinishedGoodsStorageSummaryFields {
    BigDecimal AllTotal;
    BigDecimal TotalCal;
    BigDecimal GrandTotal;
    BigDecimal requestNumberId;
}
