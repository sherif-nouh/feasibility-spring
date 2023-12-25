package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٨/٢٠٢٣
 */
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class IndustrialProfitROVODTO implements IndustrialProfitROVO{
    private BigDecimal totalValAddNatIncmCy;
    private BigDecimal tyrDepCy;

    private BigDecimal annualSales;

    private BigDecimal yearlyDepreciation;
    private long requestNumberId;
    private long licenseNumberId;

    private BigDecimal totalGrossValueAdded;
    private BigDecimal sumIndustrialProfit;

}
