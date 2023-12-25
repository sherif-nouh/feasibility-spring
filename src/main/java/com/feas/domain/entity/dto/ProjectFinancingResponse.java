package com.feas.domain.entity.dto;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٤/١٠/٢٠٢٣
 */
public interface ProjectFinancingResponse {
    public Long getProjectnumberif() ;

    public Long getRequestnumberif() ;

    public BigDecimal getPaidupcapcy();

    public BigDecimal getLoanfromindbankcy() ;

    public BigDecimal getLoanfromcommbankcy() ;

    public BigDecimal getCreditfacicy() ;

    public BigDecimal getPercinterestloanindbnr() ;

    public BigDecimal getPercinterestloancombnr() ;

    public String getUsername() ;

    public String getOperation() ;

    public Long getLicensenumberif() ;

    public Long getProjectfinancingid() ;

    public BigDecimal getFixedassetcostvalue() ;
    public BigDecimal getProjectsetupcostvalue() ;

    public BigDecimal getOperatingcapitalvalue() ;


}

