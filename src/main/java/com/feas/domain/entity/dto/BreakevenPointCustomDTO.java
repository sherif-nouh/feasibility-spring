package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ١٦/٠٢/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BreakevenPointCustomDTO implements BreakevenPointCustom{
    private BigDecimal fixedAssets;

    private BigDecimal industrialProfitCY;
    private BigDecimal yearlyProductionNR;
    private BigDecimal yearlySalesCY;
    private BigDecimal indProfit;
    private BigDecimal yearlyDepreciation;

    private BigDecimal totDeposit;
    private BigDecimal workerNos;

    private BigDecimal projectAddDepreciation;
    private BigDecimal paybackPeriodTotInvCY;
    private BigDecimal unitProduction;
    private BigDecimal estimTotInvestmentCy;
    private BigDecimal percRound;
    private  BigDecimal capitalDensityCY;

    private BigDecimal result6;


}
