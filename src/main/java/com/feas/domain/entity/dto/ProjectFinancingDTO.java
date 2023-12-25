package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٣/٢٠٢٣
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectFinancingDTO {
    private long projectFinancingId;

    private BigDecimal creditFaciCy;

    private Date dateStamp;

    private BigDecimal licenseNumberIf;

    private BigDecimal loanFromCommbankCy;

    private BigDecimal loanFromIndbankCy;

    private String operation;

    private BigDecimal paidupCapCy;

    private BigDecimal percInterestLoanCombNr;

    private BigDecimal percInterestLoanIndbNr;

    private BigDecimal projectNumberIf;

    private BigDecimal requestNumberIf;

    private String userName;

}
