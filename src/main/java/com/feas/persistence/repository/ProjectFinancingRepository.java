package com.feas.persistence.repository;

import com.feas.domain.entity.ProjectFinancing;
import com.feas.domain.entity.dto.ProjectFinancingCalculation;
import com.feas.domain.entity.dto.ProjectFinancingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@Repository
public interface ProjectFinancingRepository extends JpaRepository<ProjectFinancing,Long> {
    @Query("select p from ProjectFinancing p where p.requestNumberIf=:requestNumber and p.licenseNumberIf=:licenseNumber ")
    List<ProjectFinancing> getAllProjectFinancingByRequestNumberAndLicense(@Param("requestNumber") BigDecimal requestNumberIf,@Param("licenseNumber") BigDecimal licenseNumberIf);



    @Query(value = """
            SELECT
                projectfinancing.project_number_if projectnumberif,
                projectfinancing.request_number_if requestnumberif,
                projectfinancing.paidup_cap_cy paidupcapcy,
                projectfinancing.loan_from_indbank_cy loanfromindbankcy,
                projectfinancing.loan_from_commbank_cy loanfromcommbankcy,
                projectfinancing.credit_faci_cy creditfacicy,
                projectfinancing.perc_interest_loan_indb_nr percinterestloanindbnr,
                projectfinancing.perc_interest_loan_comb_nr percinterestloancombnr,
                projectfinancing.user_name username,
                projectfinancing.operation,
                projectfinancing.date_stamp datestamp,
                projectfinancing.license_number_if licensenumberif,
                projectfinancing.project_financing_id projectfinancingid,
                ( nvl(fixedassetcost.cost_of_build_const_cy, 0)\s
                + nvl(fixedassetcost.cost_of_equip_cy, 0)
                + nvl(fixedassetcost.cost_of_air_cond_cy,0)\s
                + nvl(fixedassetcost.cost_of_furn_cy, 0)
                + nvl(fixedassetcost.cost_of_store_prep_cy, 0)\s
                + nvl(fixedassetcost.cost_of_ext_transp_veh_cy,0)
                + nvl(fixedassetcost.cost_of_int_transp_veh_cy, 0)\s
                + nvl(fixedassetcost.cost_of_sparts_cy, 0) ) fixedassetcostvalue,
                ( nvl(projectsetupcost.cost_of_std_tech_doc_cy, 0)\s
                + nvl(projectsetupcost.cost_of_trl_consl_cy, 0)
                + nvl(projectsetupcost.cost_of_trng_cy,0)\s
                + nvl(projectsetupcost.cost_of_markt_prom_cy, 0)\s
                + nvl(projectsetupcost.cost_of_strt_prod_pre_op_cy, 0)\s
                + nvl(projectsetupcost.others_cost_cy, 0) )                projectsetupcostvalue,
                ( nvl(operatingcapital.cost_of_sto_r_mat_3months_cy, 0)\s
                + nvl(operatingcapital.cost_of_sals_2months_cy, 0) )                operatingcapitalvalue
            FROM
                project_financing  projectfinancing,
                fixed_assets_cost  fixedassetcost,
                project_setup_cost projectsetupcost,
                operating_capital  operatingcapital
            WHERE
                ( projectfinancing.request_number_if = :requestNumber )
                AND ( projectfinancing.license_number_if = :licenseNumber )
                AND fixedassetcost.request_number_if (+) = projectfinancing.request_number_if
                AND projectfinancing.operation <> 'D'
                AND projectsetupcost.request_number_if (+) = projectfinancing.request_number_if
                AND operatingcapital.request_number_if (+) = projectfinancing.request_number_if
                AND projectsetupcost.request_number_if (+) = projectfinancing.request_number_if
            
            """,nativeQuery = true)
    ProjectFinancingResponse fetchAllProjectFinancingByRequestNumberAndLicense(@Param("requestNumber") BigDecimal requestNumberIf, @Param("licenseNumber") BigDecimal licenseNumberIf);

    @Query(value=" select ProjectFinancing.PROJECT_FINANCING_ID as projectFinancingId,     \n" +
            "       ProjectFinancing.REQUEST_NUMBER_IF as requestNumberIf,\n " +
            "       (nvl(FixedAssetCost.COST_OF_BUILD_CONST_CY,0)+ nvl(FixedAssetCost.COST_OF_EQUIP_CY,0)+nvl(FixedAssetCost.COST_OF_AIR_COND_CY ,0)+           \n " +
            "       nvl(FixedAssetCost.COST_OF_FURN_CY,0)+ nvl(FixedAssetCost.COST_OF_STORE_PREP_CY,0)+nvl(FixedAssetCost.COST_OF_EXT_TRANSP_VEH_CY,0)+            \n " +
            "       nvl(FixedAssetCost.COST_OF_INT_TRANSP_VEH_CY,0)+nvl(FixedAssetCost.COST_OF_SPARTS_CY,0)) FixedAssetCostValue,          \n" +
            "               (nvl(ProjectSetupCost.COST_OF_STD_TECH_DOC_CY,0)+nvl(ProjectSetupCost.COST_OF_TRL_CONSL_CY,0)+nvl(ProjectSetupCost.COST_OF_TRNG_CY,0)+            \n " +
            "       nvl(ProjectSetupCost.COST_OF_MARKT_PROM_CY,0)+nvl(ProjectSetupCost.COST_OF_STRT_PROD_PRE_OP_CY,0)+nvl(ProjectSetupCost.OTHERS_COST_CY,0)) ProjectSetupCostValue,        \n " +
            "               (nvl(OperatingCapital.COST_OF_STO_R_MAT_3MONTHS_CY,0)+nvl(OperatingCapital.COST_OF_SALS_2MONTHS_CY,0)) OperatingCapitalValue           \n " +
            "              FROM  PROJECT_FINANCING ProjectFinancing , FIXED_ASSETS_COST FixedAssetCost               \n " +
            "                                         , PROJECT_SETUP_COST ProjectSetupCost           \n" +
            "                                         , OPERATING_CAPITAL OperatingCapital                     \n" +
            "                                         WHERE (ProjectFinancing.REQUEST_NUMBER_IF = :requestNumber ) AND (ProjectFinancing.LICENSE_NUMBER_IF = :licenseNumber )    \n" +
            "       and FixedAssetCost.REQUEST_NUMBER_IF(+)= ProjectFinancing.REQUEST_NUMBER_IF \n" +
            "       and ProjectFinancing.OPERATION<>'D'   \n" +
            "              and ProjectSetupCost.REQUEST_NUMBER_IF(+)=ProjectFinancing.REQUEST_NUMBER_IF  \n" +
            "       and OperatingCapital.REQUEST_NUMBER_IF(+)= ProjectFinancing.REQUEST_NUMBER_IF  \n" +
            "      and  ProjectSetupCost.REQUEST_NUMBER_IF(+) =ProjectFinancing.REQUEST_NUMBER_IF ",nativeQuery = true)
    ProjectFinancingCalculation getProjectFinancingCalculate(@Param("requestNumber") BigDecimal requestNumber, @Param("licenseNumber") BigDecimal licenseNumber);
}
