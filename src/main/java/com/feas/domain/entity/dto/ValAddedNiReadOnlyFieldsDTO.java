package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٦/٠٣/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValAddedNiReadOnlyFieldsDTO implements ValAddedNiReadOnlyFields{
    private BigDecimal workerRemuneration;
    private BigDecimal yearlyFixedExpenses;

    private BigDecimal advertExpCy;
    private BigDecimal buildingTools;

    private BigDecimal vehInsurcy;
    private BigDecimal projectCharge;
    private BigDecimal interestOnloan;

    private BigDecimal royalties;
    private BigDecimal remigrations;
    private BigDecimal auditingAccounts;
    private BigDecimal projectRevenue;

    private BigDecimal totalValueAddedNi;

    private BigDecimal sumProjectProfit;
    private BigDecimal publicityAdv;

    private BigDecimal requestNumberIf;
    private BigDecimal licenseNumberIf;


}
