package com.feas.domain.entity;

import com.feas.domain.entity.dto.YearlyVariableExpensId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ١٩/٠٣/٢٠٢٣
 */
@Entity
@Table(name="YEARLY_VARIABLE_EXPENSES")
@IdClass(YearlyVariableExpensId.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class YearlyVariableExpens implements Serializable {
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

    @Column(name="ALIW_DIRECT_LABOR_CY")
    private BigDecimal aliwDirectLaborCy;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Column(name="DIRECT_LABOR_SALAR_CY")
    private BigDecimal directLaborSalarCy;

    @Column(name="EMP_INSU_CY")
    private BigDecimal empInsuCy;

    @Column(name="GEN_PROD_FAC_UTI_CY")
    private BigDecimal genProdFacUtiCy;

    @Column(name="MAINT_BUILD_PROJ_CY")
    private BigDecimal maintBuildProjCy;

    @Column(name="MAINT_SPARES_EQUIP_CY")
    private BigDecimal maintSparesEquipCy;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="OTHER_EXP_CY")
    private BigDecimal otherExpCy;

    @Column(name="PERC_MAINT_BUILD_PROJ_CY")
    private BigDecimal percMaintBuildProjCy;

    @Column(name="PRINT_STAT_CY")
    private BigDecimal printStatCy;

    @Column(name="RAW_MAT_COV_PACK_CY")
    private BigDecimal rawMatCovPackCy;

    @Column(name="TOTAL_EXPENSES")
    private BigDecimal totalExpenses;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="WORK_ALLOWN_NR")
    private BigDecimal workAllownNr;

    @Transient
    private BigDecimal total5Perc;
    @Transient
    private BigDecimal totalMaintenance;

    @Transient
    private BigDecimal indirectLabour;
    @Transient
    private BigDecimal yearlyVariableExpenses;


}