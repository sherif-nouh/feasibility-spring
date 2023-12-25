package com.feas.domain.entity.dto;

import java.math.BigDecimal;

public interface ProposedProjectTempRequest {
    Long getRequestNumberId();
    BigDecimal getIndRegNrPer();

    BigDecimal getDaysGivenPer();
     BigDecimal getAdditionAreaPer();
     BigDecimal getContNoPer();
     BigDecimal getContno();
}
