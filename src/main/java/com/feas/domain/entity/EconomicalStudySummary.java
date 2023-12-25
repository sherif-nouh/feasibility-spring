package com.feas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ECONOMICAL_STUDY_SUMMARY")
@IdClass(EconomicalStudySummaryPK.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EconomicalStudySummary implements Serializable {
    @Id
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PROJECT_NUMBER_IF")
    private long projectNumberIf;
    @Id
    @Column(name = "REQUEST_NUMBER_IF")
    private long requestNumberIf;

    @Column(name = "LICENSE_NUMBER_IF")
    private long licenseNumberIf;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_STAMP")
    private Date dateStamp;

    @Column(name = "GR_VAL_ADD_TO_NAT_INM_CY")
    private BigDecimal grValAddToNatInmCy;

    @Column(name = "NET_PROFIT_CY")
    private BigDecimal netProfitCy;

    @Column(name = "NOTES_TEXT")
    private String notesText;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "REMARKS_TEXT")
    private String remarksText;

    @Column(name = "T_FIX_ASS_COST_CY")
    private BigDecimal tFixAssCostCy;

    @Column(name = "T_OPER_CAP_CY")
    private BigDecimal tOperCapCy;

    @Column(name = "T_PROJ_SETUP_COST_CY")
    private BigDecimal tProjSetupCostCy;

    @Column(name = "T_YR_DEP_CY")
    private BigDecimal tYrDepCy;

    @Column(name = "T_YR_FIXED_COST_CY")
    private BigDecimal tYrFixedCostCy;

    @Column(name = "T_YR_FIXED_EXP_CY")
    private BigDecimal tYrFixedExpCy;

    @Column(name = "T_YR_PROD_COST_CY")
    private BigDecimal tYrProdCostCy;

    @Column(name = "T_YR_VAR_EXP_CY")
    private BigDecimal tYrVarExpCy;

    @Column(name = "TOT_CAPITAL")
    private BigDecimal totCapital;

    @Column(name = "TOT_PROD_CY")
    private BigDecimal totProdCy;

    @Column(name = "TOTAL_VAL_ADD_NAT_INCM_CY")
    private BigDecimal totalValAddNatIncmCy;

    @Column(name = "TOTAL_YR_SALES_VAL_CY")
    private BigDecimal totalYrSalesValCy;

    @Column(name = "USER_NAME")
    private String userName;


}