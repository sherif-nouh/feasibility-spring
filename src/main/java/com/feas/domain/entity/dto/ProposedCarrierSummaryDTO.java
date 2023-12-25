package com.feas.domain.entity.dto;

import java.math.BigDecimal;

public class ProposedCarrierSummaryDTO implements ProposedCarrierSummary{
    public Long getLicenseNumberIf() {
        return licenseNumberIf;
    }

    public Long getRequestNumberIf() {
        return requestNumberIf;
    }

    public BigDecimal getIntTransp() {
        return intTransp;
    }

    public BigDecimal getExtTransp() {
        return extTransp;
    }

    public BigDecimal getSumTotalValue() {
        return sumTotalValue;
    }

    public ProposedCarrierSummaryDTO(Long licenseNumberIf, Long requestNumberIf, BigDecimal intTransp, BigDecimal extTransp, BigDecimal sumTotalValue) {
        this.licenseNumberIf = licenseNumberIf;
        this.requestNumberIf = requestNumberIf;
        this.intTransp = intTransp;
        this.extTransp = extTransp;
        this.sumTotalValue = sumTotalValue;
    }

    private Long licenseNumberIf;
    private Long requestNumberIf;
    private BigDecimal intTransp;
    private BigDecimal extTransp;
    private BigDecimal sumTotalValue;
}
