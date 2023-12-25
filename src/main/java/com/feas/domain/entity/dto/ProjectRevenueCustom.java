package com.feas.domain.entity.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٦/٠٧/٢٠٢٣
 */
public interface ProjectRevenueCustom {
    public long getProjectnumberif() ;

    public long getRequestnumberif() ;
    public BigDecimal getYrlysalesvalcy() ;
    public BigDecimal getYrlyprodexpcy() ;

    public BigDecimal getPercprodlosscy() ;

    public BigDecimal getProductionlossnr() ;

    public BigDecimal getProjectrevenue() ;

    public String getUsername() ;

    public String getOperation() ;

    public Date getDatestamp();

    public long getLicensenumberif() ;

    public BigDecimal getSumyrlyprodexpcy() ;

    public BigDecimal getSumyearlysalesvaluecy() ;

    public BigDecimal getFixedassetcostbuildcons() ;

    public BigDecimal getFixedassetcostequipment() ;

    public BigDecimal getYearlyfixedexpense() ;

    public BigDecimal getYearlydepreciation() ;

    public BigDecimal getYearlyvariableexpense1() ;

    public BigDecimal getYearlyvariableexpense2() ;

    public BigDecimal getYearlyvariableexpense3() ;

    public BigDecimal getYearlyvariableexpense4() ;

    public BigDecimal getYearlyvariableexpense5() ;
}
