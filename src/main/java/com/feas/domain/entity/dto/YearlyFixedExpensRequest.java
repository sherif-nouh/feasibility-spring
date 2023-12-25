package com.feas.domain.entity.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠٦/٠٨/٢٠٢٣
 */
public interface YearlyFixedExpensRequest {
    public Long getProjectNumberIf() ;

    public Long getRequestNumberIf() ;

    public Long getLicenseNumberIf() ;

    public BigDecimal getAdvertExpCy() ;

    public BigDecimal getAllowancesCy() ;

    public BigDecimal getAllpercIndmanpCostCy() ;

    public BigDecimal getAuditExpCy() ;

    public Date getDateStamp() ;

    public BigDecimal getGenExpCy() ;
    public BigDecimal getIndSpaceRentCy() ;

    public BigDecimal getInsuExpBuildtoolsCy() ;

    public BigDecimal getInsuPercexpBuildtoolsCy() ;

    public BigDecimal getNonroutineMaintExpCy() ;

    public String getOperation() ;

    public BigDecimal getOtherExpCy() ;

    public BigDecimal getProfitsNotinclProdCy() ;
    public BigDecimal getSalariesCy() ;
    public BigDecimal getTrvlAllwConsultExpCy() ;

    public String getUserName() ;

    public BigDecimal getVehInsurCy() ;

    public BigDecimal getInsurance() ;

    public BigDecimal getTotalYearlyFixedExpenses() ;

}
