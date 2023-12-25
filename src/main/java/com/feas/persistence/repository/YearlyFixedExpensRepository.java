package com.feas.persistence.repository;

import com.feas.domain.entity.YearlyFixedExpens;
import com.feas.domain.entity.YearlyFixedExpensPK;
import com.feas.domain.entity.dto.YearlyFixedExpensDTO;
import com.feas.domain.entity.dto.YearlyFixedExpensRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٢١/٠٢/٢٠٢٣
 */
public interface YearlyFixedExpensRepository extends JpaRepository<YearlyFixedExpens, YearlyFixedExpensPK> {

    @Query(value = """
            SELECT YearlyFixedExpenses.PROJECT_NUMBER_IF projectNumberIf,          \s
                             YearlyFixedExpenses.REQUEST_NUMBER_IF requestNumberIf,          \s
                             YearlyFixedExpenses.IND_SPACE_RENT_CY indSpaceRentCy,          \s
                             YearlyFixedExpenses.SALARIES_CY salariesCy ,          \s
                             YearlyFixedExpenses.ALLPERC_INDMANP_COST_CY allpercIndmanpCostCy,          \s
                             YearlyFixedExpenses.ALLOWANCES_CY allowancesCy,          \s
                             YearlyFixedExpenses.INSU_PERCEXP_BUILDTOOLS_CY insuPercexpBuildtoolsCy,          \s
                             YearlyFixedExpenses.INSU_EXP_BUILDTOOLS_CY insuExpBuildtoolsCy,          \s
                             YearlyFixedExpenses.AUDIT_EXP_CY auditExpCy,          \s
                             YearlyFixedExpenses.ADVERT_EXP_CY advertExpCy,          \s
                             YearlyFixedExpenses.TRVL_ALLW_CONSULT_EXP_CY trvlAllwConsultExpCy,          \s
                             YearlyFixedExpenses.GEN_EXP_CY genExpCy,          \s
                             YearlyFixedExpenses.PROFITS_NOTINCL_PROD_CY profitsNotinclProdCy,          \s
                             YearlyFixedExpenses.VEH_INSUR_CY vehInsurCy,          \s
                             YearlyFixedExpenses.NONROUTINE_MAINT_EXP_CY nonroutineMaintExpCy,          \s
                             YearlyFixedExpenses.OTHER_EXP_CY otherExpCy,          \s
                             YearlyFixedExpenses.USER_NAME userName,          \s
                             YearlyFixedExpenses.OPERATION operation,          \s
                             YearlyFixedExpenses.DATE_STAMP dateStamp,          \s
                             YearlyFixedExpenses.LICENSE_NUMBER_IF licenseNumberIf,         \s
                               \s
                             ((nvl(FixedAssetCost.COST_OF_BUILD_CONST_CY,0)+nvl(FixedAssetCost.COST_OF_EQUIP_CY,0))*(nvl(YearlyFixedExpenses.INSU_PERCEXP_BUILDTOOLS_CY,0)/100)) Insurance,         \s
                                    \s
                             (nvl(YearlyFixedExpenses.IND_SPACE_RENT_CY,0)+nvl(YearlyFixedExpenses.SALARIES_CY,0)+nvl(YearlyFixedExpenses.ALLOWANCES_CY,0)+    \s
                             nvl(YearlyFixedExpenses.AUDIT_EXP_CY,0)+nvl(YearlyFixedExpenses.ADVERT_EXP_CY,0)+ nvl(YearlyFixedExpenses.TRVL_ALLW_CONSULT_EXP_CY,0)+    \s
                             nvl(YearlyFixedExpenses.GEN_EXP_CY,0)+nvl(YearlyFixedExpenses.PROFITS_NOTINCL_PROD_CY,0)+ nvl(YearlyFixedExpenses.VEH_INSUR_CY,0)+    \s
                             nvl(YearlyFixedExpenses.NONROUTINE_MAINT_EXP_CY,0)+((nvl(FixedAssetCost.COST_OF_BUILD_CONST_CY,0)+    \s
                             nvl(FixedAssetCost.COST_OF_EQUIP_CY,0))*(nvl(YearlyFixedExpenses.INSU_PERCEXP_BUILDTOOLS_CY,0)/100))) totalYearlyFixedExpenses        \s
                                   \s
                        FROM  YEARLY_FIXED_EXPENSES YearlyFixedExpenses join FIXED_ASSETS_COST FixedAssetCost on FixedAssetCost.REQUEST_NUMBER_IF=YearlyFixedExpenses.REQUEST_NUMBER_IF   \s
                           \s
                         WHERE (YearlyFixedExpenses.REQUEST_NUMBER_IF = :requestNumberId ) AND (YearlyFixedExpenses.LICENSE_NUMBER_IF = :licenseNumberId )
            
            """,nativeQuery = true)
    YearlyFixedExpensRequest getYealyFixedExpense(@Param("requestNumberId") BigDecimal requestNumberId, @Param("licenseNumberId") BigDecimal licenseNumberId);

    @Query(value = " SELECT Nvl(SUM(NVL(MONTHLY_SAL_CY,0) * (NVL(NO_OF_MALE,0)+NVL(NO_OF_F_MALE,0))*12),0) as salariesCy \n " +
            " FROM PROPOSED_MANPOWER \n " +
            " WHERE  MANP_TYPE=2 \n " +
            " AND  OPERATION <> 'D' \n " +
            " AND REQUEST_NUMBER_IF=:requestNumberId ",nativeQuery = true)
    BigDecimal getSalariesCyField(@Param("requestNumberId") BigDecimal requestNumberId);

    @Query(value = "SELECT NVL(COST_OF_TRL_CONSL_CY,0) as trvlAllwConsultExpCy FROM PROJECT_SETUP_COST WHERE REQUEST_NUMBER_IF=:requestNumberId",nativeQuery = true)
    BigDecimal getTrvlAllwConsultExpCy(@Param("requestNumberId") BigDecimal requestNumberId);

    @Query(value = "SELECT nvl(SUM( NVL( UNIT_COST_CY,0)/1000 * NVL(QUANTITY_NR,0)),0) as profitsNotinclProdCyRS  \n" +
            "FROM PROPOSED_GENERAL_FACILITY , GENERAL_FACILITY \n" +
            "WHERE GEN_FAC_CODE_IF=GEN_FAC_CODE_ID \n" +
            "AND GEN_FAC_TYPE_IF=2\n" +
            "AND REQUEST_NUMBER_IF=:requestNumberId",nativeQuery = true)
    BigDecimal getProfitsNotinclProdCyRS(@Param("requestNumberId") BigDecimal requestNumberId);

    @Query(value = "SELECT (NVL(COST_OF_BUILD_CONST_CY,0)+ NVL(COST_OF_EQUIP_CY,0)) FROM FIXED_ASSETS_COST WHERE REQUEST_NUMBER_IF = :requestNumberId",nativeQuery = true)
    BigDecimal getInsurance(@Param("requestNumberId") BigDecimal requestNumberId);


    @Query(value = """
            SELECT SUM(NVL(UNIT_COST_CY,0)/1000 *NVL(QUANTITY_NR,0)) FROM PROPOSED_GENERAL_FACILITY, GENERAL_FACILITY WHERE GEN_FAC_CODE_IF=GEN_FAC_CODE_ID AND GEN_FAC_TYPE_IF=2 AND REQUEST_NUMBER_IF=:requestNumberId
            """ ,nativeQuery = true)
    BigDecimal getProfitsNotinclProdCy(@Param("requestNumberId") BigDecimal requestNumberId);

@Query(value = """
        SELECT SUM(NVL(UNIT_COST_CY,0)/1000*NVL(QUANTITY_NR,0)) FROM PROPOSED_GENERAL_FACILITY,GENERAL_FACILITY WHERE GEN_FAC_CODE_IF=GEN_FAC_CODE_ID AND GEN_FAC_TYPE_IF=1 AND REQUEST_NUMBER_IF=:requestNumberId 
        """,nativeQuery = true)
    BigDecimal generalFacilityQuery (@Param("requestNumberId") BigDecimal requestNumberId);
@Query(value = """
        SELECT DISTINCT  NVL(PRINT_STAT_CY,0) PRINT_STAT_CY, nvl(PERC_MAINT_BUILD_PROJ_CY,0) PERC_MAINT_BUILD_PROJ_CY, NVL(MAINT_SPARES_EQUIP_CY,0) MAINT_SPARES_EQUIP_CY 
                    FROM YEARLY_VARIABLE_EXPENSES WHERE REQUEST_NUMBER_IF=:requestNumberId
        """,nativeQuery = true)
     List<Object[]> yearlyVariableExpenseQuery (@Param("requestNumberId") BigDecimal requestNumberId);
@Query(value = """
        SELECT NVL(COST_OF_BUILD_CONST_CY,0) MAINTENANCE_EXP FROM FIXED_ASSETS_COST WHERE  REQUEST_NUMBER_IF=:requestNumberId
        """,nativeQuery = true)
    BigDecimal fixedAssetCostQuery1 (@Param("requestNumberId") BigDecimal requestNumberId) ;
@Query(value = """
        SELECT NVL(FIXED_ASSETS_COST.COST_OF_EQUIP_CY,0)+ NVL(FIXED_ASSETS_COST.COST_OF_SPARTS_CY,0) FROM FIXED_ASSETS_COST  where request_number_if=:requestNumberId
        """,nativeQuery = true)
    BigDecimal fixedAssetCostQuery2 (@Param("requestNumberId") BigDecimal requestNumberId) ;



}
