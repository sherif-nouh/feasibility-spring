package com.feas.persistence.repository;

import com.feas.domain.entity.YearlyDepreciation;
import com.feas.domain.entity.YearlyDepreciationPK;
import com.feas.domain.entity.dto.IndustrialProfitROVO;
import com.feas.domain.entity.dto.YearlyDepreciationCustom;
import com.feas.domain.entity.dto.YearlyFixedVariableExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
public interface YearlyDepreciationRepository extends JpaRepository<YearlyDepreciation, YearlyDepreciationPK> {


    @Query(value = " SELECT      \n" +
            "    yearlyDepreciation.license_number_if licenseNumberIf , \n" +
            "    yearlyDepreciation.request_number_if requestNumberIf , \n" +
            "    NVL(yearlyDepreciation.DEP_BUILD_CONST_CY,0)+      \n" +
            "    NVL(yearlyDepreciation.DEP_EQUIP_AFTER_INSTAL_CY,0)+      \n" +
            "    NVL(yearlyDepreciation.DEP_AIR_COND_CY,0)+      \n" +
            "    NVL(yearlyDepreciation.DEP_OF_OFF_FUR_CY,0)+      \n" +
            "    NVL(yearlyDepreciation.DEP_OF_FUR_FOR_WAHOUSE_CY,0)+      \n" +
            "    NVL(yearlyDepreciation.DEP_OF_EXT_TRANSP_CY,0)+      \n" +
            "    NVL(yearlyDepreciation.DEP_INT_TRANSP_CY,0)   tYrDepCy,       \n" +
            "          \n" +
            "    NVL(yearlyVariableExpense.RAW_MAT_COV_PACK_CY,0)+      \n" +
            "    NVL(yearlyVariableExpense.DIRECT_LABOR_SALAR_CY,0)+      \n" +
            "    nvl(NVL(yearlyVariableExpense.DIRECT_LABOR_SALAR_CY,1)*(NVL(yearlyVariableExpense.ALIW_DIRECT_LABOR_CY,1)/100),0)+      \n" +
            "    NVL(yearlyVariableExpense.EMP_INSU_CY ,0)+      \n" +
            "    NVL(yearlyVariableExpense.GEN_PROD_FAC_UTI_CY ,0)+      \n" +
            "    NVL(yearlyVariableExpense.PRINT_STAT_CY ,0) yearlyVariableExpensesCost,       \n" +
            "          \n" +
            "    fixedAssetCost.COST_OF_BUILD_CONST_CY buildingConstructionCost,       \n" +
            "    yearlyVariableExpense.PERC_MAINT_BUILD_PROJ_CY buildingMaintenanceCost,       \n" +
            "          \n" +
            "    NVL(fixedAssetCost.COST_OF_EQUIP_CY,0)+ NVL(fixedAssetCost.COST_OF_SPARTS_CY,0) fixedEquipmentCost,       \n" +
            "    yearlyVariableExpense.MAINT_SPARES_EQUIP_CY yearlySpareEquipmentCost,       \n" +
            "          \n" +
            "    nvl(yearlyFixedExpenses.IND_SPACE_RENT_Cy,0)+      \n" +
            "    nvl(yearlyFixedExpenses.SALARIES_CY,0)+                         \n" +
            "    nvl(yearlyFixedExpenses.ALLOWANCES_CY,0)+                                \n" +
            "    nvl(yearlyFixedExpenses.AUDIT_EXP_CY,0)+                         \n" +
            "    nvl(yearlyFixedExpenses.ADVERT_EXP_CY,0)+                        \n" +
            "    nvl(yearlyFixedExpenses.TRVL_ALLW_CONSULT_EXP_CY,0)+             \n" +
            "    nvl(yearlyFixedExpenses.GEN_EXP_CY,0)+                           \n" +
            "    nvl(yearlyFixedExpenses.PROFITS_NOTINCL_PROD_CY,0)+              \n" +
            "    nvl(yearlyFixedExpenses.VEH_INSUR_CY,0)+                         \n" +
            "    nvl(yearlyFixedExpenses.NONROUTINE_MAINT_EXP_CY,0)+      \n" +
            "    (NVL(fixedAssetCost.COST_OF_BUILD_CONST_CY,0)+NVL(fixedAssetCost.COST_OF_EQUIP_CY,0))*(NVL(yearlyFixedExpenses.INSU_PERCEXP_BUILDTOOLS_CY,0)/100) tYrFixedExpCy      \n" +
            "     \n" +
            " FROM YEARLY_DEPRECIATION yearlyDepreciation      \n" +
            "    join YEARLY_VARIABLE_EXPENSES yearlyVariableExpense on yearlyDepreciation.REQUEST_NUMBER_IF = yearlyVariableExpense.REQUEST_NUMBER_IF      \n" +
            "    join FIXED_ASSETS_COST fixedAssetCost on YEARLYVARIABLEEXPENSE.REQUEST_NUMBER_IF = fixedAssetCost.REQUEST_NUMBER_IF      \n" +
            "    join YEARLY_FIXED_EXPENSES yearlyFixedExpenses on YEARLYFIXEDEXPENSES.REQUEST_NUMBER_IF = yearlyVariableExpense.REQUEST_NUMBER_IF     \n" +
            "         \n" +
            "WHERE yearlyVariableExpense.REQUEST_NUMBER_IF=:requestNumberId AND yearlyVariableExpense.LICENSE_NUMBER_IF=:licenseNumberId ",nativeQuery = true)
    YearlyFixedVariableExpense getYearlyFixedVariableExpense(@Param("requestNumberId") BigDecimal requestNumberId, @Param("licenseNumberId") BigDecimal licenseNumberId);


    @Query(value = """
            SELECT
                yearlydepreciation.project_number_if,
                yearlydepreciation.request_number_if                                                                                                                                                                                                                                                                                                                         AS
                requestnumberif,
                yearlydepreciation.perc_dep_build_const_cy                                                                                                                                                                                                                                                                                                                   AS
                percdepbuildconstcy,
                yearlydepreciation.dep_build_const_cy                                                                                                                                                                                                                                                                                                                        AS
                depbuildconstcy,
                yearlydepreciation.percdep_equip_a_inst_cy                                                                                                                                                                                                                                                                                                                   AS
                percdepequipainstcy,
                yearlydepreciation.dep_equip_after_instal_cy                                                                                                                                                                                                                                                                                                                 AS
                depequipafterinstalcy,
                yearlydepreciation.perc_dep_air_cond_cy                                                                                                                                                                                                                                                                                                                      AS
                percdepaircondcy,
                yearlydepreciation.dep_air_cond_cy                                                                                                                                                                                                                                                                                                                           AS
                depaircondcy,
                yearlydepreciation.perc_dep_office_fur_cy                                                                                                                                                                                                                                                                                                                    AS
                percdepofficefurcy,
                yearlydepreciation.dep_of_off_fur_cy                                                                                                                                                                                                                                                                                                                         AS
                depofofffurcy,
                yearlydepreciation.perc_dep_of_fur_wahouse_cy                                                                                                                                                                                                                                                                                                                AS
                percdepoffurwahousecy,
                yearlydepreciation.dep_of_fur_for_wahouse_cy                                                                                                                                                                                                                                                                                                                 AS
                depoffurforwahousecy,
                yearlydepreciation.perc_dep_ext_transp_cy                                                                                                                                                                                                                                                                                                                    AS
                percdepexttranspcy,
                yearlydepreciation.dep_of_ext_transp_cy                                                                                                                                                                                                                                                                                                                      AS
                depofexttranspcy,
                yearlydepreciation.perc_dep_int_transp_cy                                                                                                                                                                                                                                                                                                                    AS
                percdepinttranspcy,
                yearlydepreciation.dep_int_transp_cy                                                                                                                                                                                                                                                                                                                         AS
                depinttranspcy,
                yearlydepreciation.other_dep_cy                                                                                                                                                                                                                                                                                                                              AS
                otherdepcy,
                yearlydepreciation.user_name                                                                                                                                                                                                                                                                                                                                 AS
                username,
                yearlydepreciation.operation                                                                                                                                                                                                                                                                                                                                 AS
                operation,
                yearlydepreciation.date_stamp,
                yearlydepreciation.license_number_if                                                                                                                                                                                                                                                                                                                         AS
                licensenumberif,
                ( nvl(yearlydepreciation.dep_build_const_cy, 0) + nvl(yearlydepreciation.dep_equip_after_instal_cy, 0) + nvl(yearlydepreciation.dep_air_cond_cy,
                0) + nvl(yearlydepreciation.dep_of_off_fur_cy, 0) + nvl(yearlydepreciation.dep_of_fur_for_wahouse_cy, 0) + nvl(yearlydepreciation.
                dep_of_ext_transp_cy, 0) + nvl(yearlydepreciation.dep_int_transp_cy, 0) ) yealrydepreciationvalue,
                nvl(fixedassetcost.cost_of_build_const_cy, 0)                                                                                                                                                                                                                                                                                                                building,
                nvl(fixedassetcost.cost_of_equip_cy, 0)                                                                                                                                                                                                                                                                                                                      equipment,
                nvl(fixedassetcost.cost_of_air_cond_cy, 0)                                                                                                                                                                                                                                                                                                                   aircondition,
                nvl(fixedassetcost.cost_of_furn_cy, 0)                                                                                                                                                                                                                                                                                                                       furniture,
                nvl(fixedassetcost.cost_of_store_prep_cy, 0)                                                                                                                                                                                                                                                                                                                 store,
                nvl(fixedassetcost.cost_of_ext_transp_veh_cy, 0)                                                                                                                                                                                                                                                                                                             evehicle,
                nvl(fixedassetcost.cost_of_int_transp_veh_cy, 0)                                                                                                                                                                                                                                                                                                             ivehicle
            FROM
                     yearly_depreciation yearlydepreciation
                JOIN fixed_assets_cost fixedassetcost ON fixedassetcost.request_number_if = yearlydepreciation.request_number_if
            WHERE
                ( yearlydepreciation.request_number_if = :requestnumberid )
                AND ( yearlydepreciation.license_number_if = :licensenumberid )""" ,nativeQuery = true)
    YearlyFixedVariableExpense getYearlyDepreciationByLicAndReq(@Param("requestnumberid") long requestNumberId, @Param("licensenumberid") long licenseNumberId);


    YearlyDepreciation  findYearlyDepreciationById(YearlyDepreciationPK yearlyDepreciationPK);


@Query(value = """
        select      
        nvl((      
        SELECT NVL(VAL_ADDED_NI.PROJECT_CHARGES,0)+      
                NVL(VAL_ADDED_NI.WORKER_REMUNERATION,0)+      
                NVL(VAL_ADDED_NI.AUDITING_ACCOUNTS,0)+      
                NVL(VAL_ADDED_NI.BUILDING_TOOLS,0)+      
                NVL(VAL_ADDED_NI.PUBLICITY_ADV,0)+      
                NVL(VAL_ADDED_NI.VEH_INSUR_CY,0)+      
                NVL(VAL_ADDED_NI.REMIGRATIONS,0)      
                FROM VAL_ADDED_NI       
                WHERE       
            REQUEST_NUMBER_IF = :requestNumberId      
            AND LICENSE_NUMBER_IF = :licenseNumberId      
            and OPERATION <>'D'      
        ),0)  totalValAddNatIncmCy  --صافي القيمة المضافة للدخل القومي      
        ,NVL      
        ((      
        SELECT      
                                NVL(YEARLY_DEPRECIATION.DEP_BUILD_CONST_CY,0)+      
                                NVL(YEARLY_DEPRECIATION.DEP_EQUIP_AFTER_INSTAL_CY,0)+      
                                NVL(YEARLY_DEPRECIATION.DEP_AIR_COND_CY,0)+      
                                NVL(YEARLY_DEPRECIATION.DEP_OF_OFF_FUR_CY,0)+      
                                NVL(YEARLY_DEPRECIATION.DEP_OF_FUR_FOR_WAHOUSE_CY,0)+      
                                NVL(YEARLY_DEPRECIATION.DEP_OF_EXT_TRANSP_CY,0)+      
                                NVL(YEARLY_DEPRECIATION.DEP_INT_TRANSP_CY,0)      
                                --INTO :INDUSTRIAL_PROFIT.T_YR_DEP_CY      
                        FROM YEARLY_DEPRECIATION      
                           WHERE      
                          REQUEST_NUMBER_IF = :requestNumberId      
                              AND LICENSE_NUMBER_IF = :licenseNumberId and YEARLY_DEPRECIATION.OPERATION <> 'D'      
        ),0) tyrDepCy  --الاستهلاكات السنوية      
        ,NVL((      
               SELECT SUM(nvl(ESTIMATED_YEARLY_SALES.QUANTITY_NR,0)*      
                        nvl(ESTIMATED_YEARLY_SALES.UNIT_PRICE_CY,0))      
                        FROM ESTIMATED_YEARLY_SALES WHERE      
                        REQUEST_NUMBER_IF = :requestNumberId AND OPERATION<>'D'      
                            AND LICENSE_NUMBER_IF = :licenseNumberId      
        ),0) annualSales -- قيمة المبيعات السنوية      
        ,     
        NVL((     
        SELECT     
        						NVL(YEARLY_DEPRECIATION.DEP_BUILD_CONST_CY,0)+     
        						NVL(YEARLY_DEPRECIATION.DEP_EQUIP_AFTER_INSTAL_CY,0)+     
        						NVL(YEARLY_DEPRECIATION.DEP_AIR_COND_CY,0)+     
        						NVL(YEARLY_DEPRECIATION.DEP_OF_OFF_FUR_CY,0)+     
        						NVL(YEARLY_DEPRECIATION.DEP_OF_FUR_FOR_WAHOUSE_CY,0)+     
        						NVL(YEARLY_DEPRECIATION.DEP_OF_EXT_TRANSP_CY,0)+     
        						NVL(YEARLY_DEPRECIATION.DEP_INT_TRANSP_CY,0)     
        					     
        				FROM YEARLY_DEPRECIATION     
        				   WHERE     
        				  REQUEST_NUMBER_IF = :requestNumberId     
        				  	AND LICENSE_NUMBER_IF = :licenseNumberId     
                             and OPERATION <>'D'    
             
        ),0) yearlyDepreciation  -- التكاليف المتغيرة السنوية      
           , :requestNumberId as requestNumberId
           , :licenseNumberId as licenseNumberId
        from DUAL
        """ ,nativeQuery = true)
    IndustrialProfitROVO getIndustrialProfitROVO(@Param("requestNumberId") long requestNumberId, @Param("licenseNumberId") long licenseNumberId);

}
