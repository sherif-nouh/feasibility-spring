package com.feas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@Entity
@Table(name="PROJECT_FINANCING")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectFinancing implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="PROJECT_FINANCING_ID")
    private long projectFinancingId;

    @Column(name="CREDIT_FACI_CY")
    private BigDecimal creditFaciCy;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Column(name="LICENSE_NUMBER_IF")
    private BigDecimal licenseNumberIf;

    @Column(name="LOAN_FROM_COMMBANK_CY")
    private BigDecimal loanFromCommbankCy;

    @Column(name="LOAN_FROM_INDBANK_CY")
    private BigDecimal loanFromIndbankCy;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="PAIDUP_CAP_CY")
    private BigDecimal paidupCapCy;

    @Column(name="PERC_INTEREST_LOAN_COMB_NR")
    private BigDecimal percInterestLoanCombNr;

    @Column(name="PERC_INTEREST_LOAN_INDB_NR")
    private BigDecimal percInterestLoanIndbNr;

    @Column(name="PROJECT_NUMBER_IF")
    private BigDecimal projectNumberIf;

    @Column(name="REQUEST_NUMBER_IF")
    private BigDecimal requestNumberIf;

    @Column(name="USER_NAME")
    private String userName;

    @Transient
    private BigDecimal FixedAssetCostValue;
    @Transient
    private BigDecimal ProjectSetupCostValue;
    @Transient
    private BigDecimal OperatingCapitalValue;
    @Transient
    private BigDecimal totalFinancing;
    @Transient
    private BigDecimal industrialBank;
@Transient
    private BigDecimal commercialBank;

}
