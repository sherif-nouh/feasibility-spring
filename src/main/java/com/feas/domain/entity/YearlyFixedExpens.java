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
 * @Date ٢١/٠٢/٢٠٢٣
 */
@Entity
@Table(name="YEARLY_FIXED_EXPENSES")
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(YearlyFixedExpensPK.class)
public class YearlyFixedExpens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="PROJECT_NUMBER_IF")
    private long projectNumberIf;
    @Id
    @Column(name="REQUEST_NUMBER_IF")
    private long requestNumberIf;
    @Id
    @Column(name="LICENSE_NUMBER_IF")
    private long licenseNumberIf;
    @Column(name="ADVERT_EXP_CY")
    private BigDecimal advertExpCy;

    @Column(name="ALLOWANCES_CY")
    private BigDecimal allowancesCy;

    @Column(name="ALLPERC_INDMANP_COST_CY")
    private BigDecimal allpercIndmanpCostCy;

    @Column(name="AUDIT_EXP_CY")
    private BigDecimal auditExpCy;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Column(name="GEN_EXP_CY")
    private BigDecimal genExpCy;

    @Column(name="IND_SPACE_RENT_CY")
    private BigDecimal indSpaceRentCy;

    @Column(name="INSU_EXP_BUILDTOOLS_CY")
    private BigDecimal insuExpBuildtoolsCy;

    @Column(name="INSU_PERCEXP_BUILDTOOLS_CY")
    private BigDecimal insuPercexpBuildtoolsCy;

    @Column(name="NONROUTINE_MAINT_EXP_CY")
    private BigDecimal nonroutineMaintExpCy;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="OTHER_EXP_CY")
    private BigDecimal otherExpCy;

    @Column(name="PROFITS_NOTINCL_PROD_CY")
    private BigDecimal profitsNotinclProdCy;

    @Column(name="SALARIES_CY")
    private BigDecimal salariesCy;

    @Column(name="TRVL_ALLW_CONSULT_EXP_CY")
    private BigDecimal trvlAllwConsultExpCy;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="VEH_INSUR_CY")
    private BigDecimal vehInsurCy;
    @Transient
    private BigDecimal insurance;
    @Transient
    private BigDecimal totalYearlyFixedExpenses;
}