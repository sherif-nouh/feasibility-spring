package com.feas.domain.entity.dto;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٧/٠٢/٢٠٢٣
 */
public interface CalculateIndustrialCost {

    public BigDecimal getSumTotalArea() ;

    public BigDecimal getTotalLandExp() ;

    public BigDecimal getSupervisionExp() ;
    public BigDecimal getGrandTotal() ;

    public BigDecimal getRequestNumberIf() ;
    public BigDecimal getSumSqm();
}
