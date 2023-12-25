package com.feas.domain.entity.dto;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٢/٢٠٢٣
 */
public interface SumGeneralFacility {
    public BigDecimal getTotalNonProductive() ;

    public BigDecimal getTotalProductive() ;

    public BigDecimal getTotalGeneralFacility() ;

    public BigDecimal getRequestNumberIf() ;
}
