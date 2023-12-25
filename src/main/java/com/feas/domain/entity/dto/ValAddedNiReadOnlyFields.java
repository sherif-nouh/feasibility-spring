package com.feas.domain.entity.dto;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٦/٠٣/٢٠٢٣
 */
public interface ValAddedNiReadOnlyFields {

    public BigDecimal getWorkerRemuneration() ;

    public BigDecimal getYearlyFixedExpenses() ;

    public BigDecimal getAdvertExpCy() ;

    public BigDecimal getBuildingTools() ;

    public BigDecimal getVehInsurcy() ;

    public BigDecimal getProjectCharge() ;

    public BigDecimal getInterestOnloan() ;

    public BigDecimal getRoyalties();

    public BigDecimal getRemigrations() ;

    public BigDecimal getAuditingAccounts() ;

    public BigDecimal getProjectRevenue() ;
    public BigDecimal getTotalValueAddedNi();
    public BigDecimal getSumProjectProfit();
    public BigDecimal getPublicityAdv() ;
    public BigDecimal getRequestNumberIf() ;

    public BigDecimal getLicenseNumberIf() ;
}
