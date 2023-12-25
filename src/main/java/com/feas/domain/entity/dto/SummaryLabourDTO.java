package com.feas.domain.entity.dto;

import java.math.BigDecimal;

public class SummaryLabourDTO implements SummaryLabour{

    private BigDecimal summaryEmployee;
    private BigDecimal summaryLabour;
    private BigDecimal summaryYearly;
    private BigDecimal tinDirect;


    private BigDecimal tDirect;

    public SummaryLabourDTO(BigDecimal summaryEmployee, BigDecimal summaryLabour, BigDecimal summaryYearly, BigDecimal tinDirect, BigDecimal tDirect) {
        this.summaryEmployee = summaryEmployee;
        this.summaryLabour = summaryLabour;
        this.summaryYearly = summaryYearly;
        this.tinDirect = tinDirect;
        this.tDirect = tDirect;
    }

    public BigDecimal getSummaryEmployee() {
        return summaryEmployee;
    }

    public void setSummaryEmployee(BigDecimal summaryEmployee) {
        this.summaryEmployee = summaryEmployee;
    }

    public BigDecimal getSummaryLabour() {
        return summaryLabour;
    }

    public void setSummaryLabour(BigDecimal summaryLabour) {
        this.summaryLabour = summaryLabour;
    }

    public BigDecimal getSummaryYearly() {
        return summaryYearly;
    }

    public void setSummaryYearly(BigDecimal summaryYearly) {
        this.summaryYearly = summaryYearly;
    }

    public BigDecimal getTinDirect() {
        return tinDirect;
    }

    public void setTinDirect(BigDecimal tinDirect) {
        this.tinDirect = tinDirect;
    }

    public BigDecimal gettDirect() {
        return tDirect;
    }

    public void settDirect(BigDecimal tDirect) {
        this.tDirect = tDirect;
    }
}
