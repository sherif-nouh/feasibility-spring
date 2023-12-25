package com.feas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TECHNICAL_STUDY_SUMMARY")
@IdClass(TechnicalStudySummaryPK.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TechnicalStudySummary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PROJECT_NUMBER_IF")
    private long projectNumberIf;
    @Id
    @Column(name = "REQUEST_NUMBER_IF")
    private long requestNumberIf;
    @Id
    @Column(name = "LICENSE_NUMBER_IF")
    private long licenseNumberIf;

    @Column(name = "ADD_AREA_REQ_MOVM_NR")
    private BigDecimal addAreaReqMovmNr;

    @Column(name = "COST_BUILD_CONST_CY")
    private BigDecimal costBuildConstCy;

    @Column(name = "COST_FAC_NON_PROD_CY")
    private BigDecimal costFacNonProdCy;

    @Column(name = "COST_FAC_PROD_CY")
    private BigDecimal costFacProdCy;

    @Column(name = "COST_LAND_PREP_CY")
    private BigDecimal costLandPrepCy;

    @Column(name = "COST_SUPERV_ENGI_WORK_CY")
    private BigDecimal costSupervEngiWorkCy;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_STAMP")
    private Date dateStamp;

    @Column(name = "EST_COST_FAC_CY")
    private BigDecimal estCostFacCy;

    @Column(name = "EXP_TRANSP_DUTIES_CY")
    private BigDecimal expTranspDutiesCy;

    @Column(name = "GR_EXP_MAT_PROD_CY")
    private BigDecimal grExpMatProdCy;

    @Column(name = "GR_VAL_LOC_PUR_EQUIP_CY")
    private BigDecimal grValLocPurEquipCy;

    @Column(name = "INSTAL_EXP_CY")
    private BigDecimal instalExpCy;

    @Column(name = "NOTES_TX")
    private String notesTx;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "PERC_ADD_AREA_FGREQ_MOVM_NR")
    private BigDecimal percAddAreaFgreqMovmNr;

    @Column(name = "PERC_ADD_AREA_REQ_MOVM_NR")
    private BigDecimal percAddAreaReqMovmNr;

    @Column(name = "PERC_ADD_AREA_REQ_PLMOVM_NR")
    private BigDecimal percAddAreaReqPlmovmNr;

    @Column(name = "PERC_LOCMAT_TO_TMATVAL_PROD_NR")
    private BigDecimal percLocmatToTmatvalProdNr;

    @Column(name = "PROD_SPEC_TX")
    private String prodSpecTx;

    @Column(name = "SUMM_OF_PROD_TX")
    private String summOfProdTx;

    @Column(name = "T_ACT_AREA_REQ_FGSTOR_NR")
    private BigDecimal tActAreaReqFgstorNr;

    @Column(name = "T_ACT_AREA_REQ_MACHI_NR")
    private BigDecimal tActAreaReqMachiNr;

    @Column(name = "T_ACT_AREA_REQ_RMSTOR_NR")
    private BigDecimal tActAreaReqRmstorNr;

    @Column(name = "T_AREA_FG_NR")
    private BigDecimal tAreaFgNr;

    @Column(name = "T_AREA_PL_NR")
    private BigDecimal tAreaPlNr;

    @Column(name = "T_AREA_REQ_PROJECT_NR")
    private BigDecimal tAreaReqProjectNr;

    @Column(name = "T_AREA_RM_NR")
    private BigDecimal tAreaRmNr;

    @Column(name = "T_COST_BUILD_CONST_CY")
    private BigDecimal tCostBuildConstCy;

    @Column(name = "T_EXP_EQUIP_AFTER_INSTAL_CY")
    private BigDecimal tExpEquipAfterInstalCy;

    @Column(name = "T_NO_ACT_EMP_NR")
    private BigDecimal tNoActEmpNr;

    @Column(name = "T_NO_APP_EMP_NR")
    private BigDecimal tNoAppEmpNr;

    @Column(name = "T_NO_PROP_EMP_NR")
    private BigDecimal tNoPropEmpNr;

    @Column(name = "T_NO_STAFF_APP_NR")
    private BigDecimal tNoStaffAppNr;

    @Column(name = "T_NO_STAFF_REQ_NR")
    private BigDecimal tNoStaffReqNr;

    @Column(name = "T_VAL_CY")
    private BigDecimal tValCy;

    @Column(name = "T_VAL_EXT_TRANSP_VEH_CY")
    private BigDecimal tValExtTranspVehCy;

    @Column(name = "T_VAL_IMP_EQU_CIF_CY")
    private BigDecimal tValImpEquCifCy;

    @Column(name = "T_VAL_IMP_EQUIP_FOB_CY")
    private BigDecimal tValImpEquipFobCy;

    @Column(name = "T_VAL_INT_TRANSP_VEH_CY")
    private BigDecimal tValIntTranspVehCy;

    @Column(name = "T_VAL_MAT_AVAIL_LOC_CY")
    private BigDecimal tValMatAvailLocCy;

    @Column(name = "T_VAL_MAT_PROD_CIF_CY")
    private BigDecimal tValMatProdCifCy;

    @Column(name = "T_VAL_OF_CARRIER")
    private BigDecimal tValOfCarrier;

    @Column(name = "T_YEARLY_COST_FAC_CY")
    private BigDecimal tYearlyCostFacCy;

    @Column(name = "T_YEARLY_LABOR_COST_CY")
    private BigDecimal tYearlyLaborCostCy;

    @Column(name = "T_YEARLY_SAL_CY")
    private BigDecimal tYearlySalCy;

    @Column(name = "TRANSP_CLE_EXP_CY")
    private BigDecimal transpCleExpCy;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "VAL_LOCMAT_TO_TMATVAL_PROD_NR")
    private BigDecimal valLocmatToTmatvalProdNr;

   @PrePersist
    private void beforeNewRecord(){
       this.setOperation("I");
       this.setDateStamp(new Date());
   }
    @PreUpdate
    private void beforeUpdate(){
        this.setOperation("U");
        this.setDateStamp(new Date());
    }
}