package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٧/٠٢/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalculateIndustrialCostDTO implements  CalculateIndustrialCost{

    private BigDecimal sumTotalArea;
    private BigDecimal totalLandExp;
    private BigDecimal supervisionExp;
    private BigDecimal grandTotal;
    private BigDecimal requestNumberIf;

    private BigDecimal sumSqm;


}
