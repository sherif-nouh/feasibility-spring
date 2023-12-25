package com.feas.domain.entity.dto;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٨/٢٠٢٣
 */
public interface IndustrialProfitROVO {

    public BigDecimal getTotalValAddNatIncmCy() ;

    public BigDecimal getTyrDepCy() ;

    public BigDecimal getAnnualSales() ;

    public BigDecimal getYearlyDepreciation() ;
    public long getRequestNumberId() ;

    public long getLicenseNumberId() ;

    public BigDecimal getTotalGrossValueAdded() ;

    public BigDecimal getSumIndustrialProfit() ;
}
