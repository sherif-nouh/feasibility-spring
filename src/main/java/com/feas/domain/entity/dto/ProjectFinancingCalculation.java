package com.feas.domain.entity.dto;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٣/٢٠٢٣
 */

public interface ProjectFinancingCalculation {

    public BigDecimal getProjectFinancingId() ;

    public BigDecimal getRequestNumberIf() ;

    public BigDecimal getFixedAssetCostValue() ;

    public BigDecimal getProjectSetupCostValue() ;

    public BigDecimal getOperatingCapitalValue() ;

}
