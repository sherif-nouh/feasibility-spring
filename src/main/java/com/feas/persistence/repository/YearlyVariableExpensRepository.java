package com.feas.persistence.repository;

import com.feas.domain.entity.YearlyVariableExpens;
import com.feas.domain.entity.dto.CalculatedYearlyVariableExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ١٩/٠٣/٢٠٢٣
 */
public interface YearlyVariableExpensRepository extends JpaRepository<YearlyVariableExpens,Long> {


    public YearlyVariableExpens findFirstByRequestNumberIfAndLicenseNumberIfOrderByRequestNumberIfDesc(long requestNumberIf, long licenseNumberIf);



    @Query(value = "  select ((nvl(FixedAssetCost.COST_OF_EQUIP_CY,0)+nvl(FixedAssetCost.COST_OF_SPARTS_CY,0))*(nvl(YearlyVariableExpenses.MAINT_SPARES_EQUIP_CY,0)))/100 total5Perc,        " +
            "              \n" +
            "       (nvl(YearlyVariableExpenses.PERC_MAINT_BUILD_PROJ_CY,0) * (ROUND(FixedAssetCost.COST_OF_BUILD_CONST_CY,4)))/100 totalMaintenance ,       " +
            "            \n" +
            "       YearlyVariableExpenses.DIRECT_LABOR_SALAR_CY*(YearlyVariableExpenses.ALIW_DIRECT_LABOR_CY/100) indirectLabour ,      " +
            "              \n" +
            "       ( nvl(YearlyVariableExpenses.RAW_MAT_COV_PACK_CY,0)+nvl(YearlyVariableExpenses.DIRECT_LABOR_SALAR_CY,0)+nvl(YearlyVariableExpenses.ALIW_DIRECT_LABOR_CY,0) +          " +
            "       nvl(YearlyVariableExpenses.EMP_INSU_CY,0)+nvl(YearlyVariableExpenses.GEN_PROD_FAC_UTI_CY,0)+nvl(YearlyVariableExpenses.PRINT_STAT_CY,0) +          " +
            "       ((nvl(FixedAssetCost.COST_OF_EQUIP_CY,0)+nvl(FixedAssetCost.COST_OF_SPARTS_CY,0))*(nvl(YearlyVariableExpenses.MAINT_SPARES_EQUIP_CY,0)/100))) yearlyVariableExpenses          " +
            "                          \n " +
            "                     \n " +
            " FROM  YEARLY_VARIABLE_EXPENSES YearlyVariableExpenses join FIXED_ASSETS_COST FixedAssetCost on FixedAssetCost.REQUEST_NUMBER_IF=YearlyVariableExpenses.REQUEST_NUMBER_IF         " +
            " WHERE (YearlyVariableExpenses.REQUEST_NUMBER_IF = :requestNumberIf ) AND (YearlyVariableExpenses.LICENSE_NUMBER_IF = :licenseNumberIf )",nativeQuery = true)
    public CalculatedYearlyVariableExpense getCalculatedYearlyVariableExpense(@Param("licenseNumberIf") Long licenseNumberIf, @Param("requestNumberIf") Long requestNumberIf);

    @Query(value = "SELECT ROUND(SUM(((nvl(NO_OF_MALE,0)+NVL( NO_OF_F_MALE,0)) * (MONTHLY_SAL_CY))*12),4)  FROM   PROPOSED_MANPOWER WHERE  MANP_TYPE=1 AND REQUEST_NUMBER_IF=:requestNumberIf AND OPERATION <> 'D' ",nativeQuery = true)
    public BigDecimal getDirectLaborSalarCy( @Param("requestNumberIf") Long requestNumberIf);
    @Query(value = " SELECT ROUND(T_VAL_MAT_PROD_CIF_CY,4) FROM TECHNICAL_STUDY_SUMMARY WHERE REQUEST_NUMBER_IF= :requestNumberIf" ,nativeQuery = true)
    public BigDecimal getRawMatCovPackCy( @Param("requestNumberIf") Long requestNumberIf);

    @Query(value = " SELECT ROUND(SUM(NVL(UNIT_COST_CY,0)/1000*NVL(QUANTITY_NR,0)),4) FROM PROPOSED_GENERAL_FACILITY,GENERAL_FACILITY WHERE GEN_FAC_CODE_IF=GEN_FAC_CODE_ID AND GEN_FAC_TYPE_IF=1 AND REQUEST_NUMBER_IF=:requestNumberIf " ,nativeQuery = true)
    public BigDecimal genProdFacUtiCyQuery(@Param("requestNumberIf") Long requestNumberIf);








}
