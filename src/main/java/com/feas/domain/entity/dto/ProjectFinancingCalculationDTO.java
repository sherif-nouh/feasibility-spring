package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٣/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectFinancingCalculationDTO implements ProjectFinancingCalculation{
    private BigDecimal projectFinancingId;
    private BigDecimal requestNumberIf;
    private BigDecimal fixedAssetCostValue;
    private BigDecimal projectSetupCostValue;
    private BigDecimal operatingCapitalValue;


}
