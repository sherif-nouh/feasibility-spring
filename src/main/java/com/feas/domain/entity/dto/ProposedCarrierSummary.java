package com.feas.domain.entity.dto;

import java.math.BigDecimal;

public interface ProposedCarrierSummary {
    public Long getLicenseNumberIf();

    public Long getRequestNumberIf() ;

    public BigDecimal getIntTransp() ;

    public BigDecimal getExtTransp() ;

    public BigDecimal getSumTotalValue() ;
}
