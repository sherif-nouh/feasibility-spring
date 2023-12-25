package com.feas.domain.entity.dto;

import java.math.BigDecimal;

public class ProposedProjectTempRequestDTO implements ProposedProjectTempRequest {
    private Long requestNumberId;
    private BigDecimal indRegNrPer;

    private BigDecimal daysGivenPer;
    private BigDecimal additionAreaPer;
    private BigDecimal contNoPer;
    private BigDecimal contno;

    public ProposedProjectTempRequestDTO() {
    }

    public ProposedProjectTempRequestDTO(Long requestNumberId, BigDecimal indRegNrPer, BigDecimal daysGivenPer, BigDecimal additionAreaPer, BigDecimal contNoPer, BigDecimal contno) {
        this.requestNumberId = requestNumberId;
        this.indRegNrPer = indRegNrPer;
        this.daysGivenPer = daysGivenPer;
        this.additionAreaPer = additionAreaPer;
        this.contNoPer = contNoPer;
        this.contno = contno;
    }

    public Long getRequestNumberId() {
        return requestNumberId;
    }

    public void setRequestNumberId(Long requestNumberId) {
        this.requestNumberId = requestNumberId;
    }

    public BigDecimal getIndRegNrPer() {
        return indRegNrPer;
    }

    public void setIndRegNrPer(BigDecimal indRegNrPer) {
        this.indRegNrPer = indRegNrPer;
    }

    public BigDecimal getDaysGivenPer() {
        return daysGivenPer;
    }

    public void setDaysGivenPer(BigDecimal daysGivenPer) {
        this.daysGivenPer = daysGivenPer;
    }

    public BigDecimal getAdditionAreaPer() {
        return additionAreaPer;
    }

    public void setAdditionAreaPer(BigDecimal additionAreaPer) {
        this.additionAreaPer = additionAreaPer;
    }

    public BigDecimal getContNoPer() {
        return contNoPer;
    }

    public void setContNoPer(BigDecimal contNoPer) {
        this.contNoPer = contNoPer;
    }

    public BigDecimal getContno() {
        return contno;
    }

    public void setContno(BigDecimal contno) {
        this.contno = contno;
    }
}
