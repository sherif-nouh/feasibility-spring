package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ReportContentDTO {
        private long reportContentId;
        private String numberAr;
        private String detailTx;
        private String pageNoTx;
        private String userName;
        private String operation;
        private BigDecimal requestNumberIf;
        private BigDecimal licenseNumberIf;
        private BigDecimal projectNumberIf;
        private BigDecimal orderNr;








}
