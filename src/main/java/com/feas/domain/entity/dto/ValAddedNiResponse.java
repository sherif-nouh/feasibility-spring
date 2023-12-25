package com.feas.domain.entity.dto;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٥/١٠/٢٠٢٣
 */
public interface ValAddedNiResponse {

    public Long getEconStudyNumberIf() ;
    public Long getProjectCharges() ;
    public BigDecimal getWorkerRemuneration() ;

    public BigDecimal getAuditingAccounts() ;
    public BigDecimal getBuildingTools() ;

    public BigDecimal getPublicityAdv() ;

    public BigDecimal getVehInsurCy() ;

    public BigDecimal getRemigrations() ;

    public Long getLicenseNumberIf() ;

    public Long getRequestNumberIf() ;

    public BigDecimal getOperation() ;

    public BigDecimal getInsertBy() ;

    public BigDecimal getModifyBy() ;

    public BigDecimal getTotalvalueadded() ;

    public BigDecimal getInterestonloan() ;

    public BigDecimal getSumprojectprofit() ;
    public BigDecimal getRoyalties() ;
}
