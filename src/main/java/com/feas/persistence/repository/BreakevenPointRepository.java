package com.feas.persistence.repository;

import com.feas.domain.entity.dto.BreakevenPointCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.feas.domain.entity.BreakevenPoint;
import com.feas.domain.entity.BreakevenPointPK;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Repository
public interface BreakevenPointRepository extends JpaRepository<BreakevenPoint, BreakevenPointPK> {

    @Query(value = " \n" +
            "  select NVL(( \n" +
            " SELECT nvl(\t\t\t \n" +
            "nvl(y.IND_SPACE_RENT_Cy,0)+ \n" +
            "nvl(y.SALARIES_CY,0)+                    \n" +
            "nvl(y.ALLOWANCES_CY,0)+                           \n" +
            "nvl(y.AUDIT_EXP_CY,0)+                    \n" +
            "nvl(y.ADVERT_EXP_CY,0)+                   \n" +
            "nvl(y.TRVL_ALLW_CONSULT_EXP_CY,0)+        \n" +
            "nvl(y.GEN_EXP_CY,0)+                      \n" +
            "nvl(y.PROFITS_NOTINCL_PROD_CY,0)+         \n" +
            "nvl(y.VEH_INSUR_CY,0)+                    \n" +
            "nvl(y.NONROUTINE_MAINT_EXP_CY,0)+ \n" +
            "((NVL(f.COST_OF_BUILD_CONST_CY,0)+ NVL(f.COST_OF_EQUIP_CY,0)) *(y.INSU_PERCEXP_BUILDTOOLS_CY/100)) \n" +
            ",0) total1 \n" +
            "FROM YEARLY_FIXED_EXPENSES y ,FIXED_ASSETS_COST f \n" +
            "\t\t\t \n" +
            "\t\t\tWHERE  y.REQUEST_NUMBER_IF = :REQ_NO \n" +
            "\t\t\tAND y.LICENSE_NUMBER_IF = :LIC_NO  \n" +
            "\t\t\t\t\tand f.REQUEST_NUMBER_IF = :REQ_NO  \n" +
            "\t\t\t\t\tAND f.LICENSE_NUMBER_IF = :LIC_NO)  \n" +
            "  +         \n" +
            "    (     \n" +
            "          SELECT \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_BUILD_CONST_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_EQUIP_AFTER_INSTAL_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_AIR_COND_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_OF_OFF_FUR_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_OF_FUR_FOR_WAHOUSE_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_OF_EXT_TRANSP_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_INT_TRANSP_CY,0)  total3 \n" +
            "\t\t\t\t\t\t \n" +
            "\t\t\t\t\t\tFROM YEARLY_DEPRECIATION \n" +
            "\t\t\t\t\t\t   WHERE \n" +
            "              REQUEST_NUMBER_IF = :REQ_NO \n" +
            "\t\t\t\t\tAND LICENSE_NUMBER_IF = :LIC_NO),0) fixedAssets      --FixedAssets is total1+ total2 ألتكاليف الثابته \n" +
            "           \n" +
            "    , \n" +
            "     \n" +
            "   NVL( nvl(( \n" +
            "    SELECT \tSUM(nvl(ESTIMATED_YEARLY_SALES.QUANTITY_NR,0)* \n" +
            "\t\t\t\t\t\t\t\tnvl(ESTIMATED_YEARLY_SALES.UNIT_PRICE_CY,0)) \n" +
            "\t\t\t\tFROM \t\tESTIMATED_YEARLY_SALES  \n" +
            "\t\t\t\tWHERE\t\tREQUEST_NUMBER_IF = :REQ_NO \n" +
            "\t\t\t\tAND LICENSE_NUMBER_IF = :LIC_NO \n" +
            "\t\t\t\tAND OPERATION<>'D' \n" +
            "    ),0)   \n" +
            "   - \n" +
            "    NVL(( \n" +
            "    \t   select T_YR_VAR_EXP_CY \n" +
            "\t\t\t\t\tFROM ECONOMICAL_STUDY_SUMMARY \n" +
            "\t\t\t\t\t   WHERE \n" +
            "\t\t\t\t\tREQUEST_NUMBER_IF = :REQ_NO \n" +
            "\t\t\t\t\t\tAND LICENSE_NUMBER_IF = :LIC_NO \n" +
            "\t\t\t\t\t\tAND NVL(OPERATION,'I')<>'D' \n" +
            "    ),0) ,0) industrialProfitCY  -- الارباح الصناعيه  == V_RET1-V_RET \n" +
            "    , \n" +
            "   nvl( ( SELECT    \n" +
            "  sum(NVL(ES.QUANTITY_NR,0)) SALES_VALUE  \n" +
            "  FROM ESTIMATED_YEARLY_SALES ES  \n" +
            "  WHERE ES.REQUEST_NUMBER_IF = :REQ_NO \n" +
            "  AND OPERATION <> 'D' ),0)  yearlyProductionNR -- حجم الانتاج السنوي  \n" +
            "     , \n" +
            "       nvl((SELECT    \n" +
            "  sum(NVL(ES.QUANTITY_NR,0)* NVL(ES.UNIT_PRICE_CY,0))  V_TOT_SALES \n" +
            "  FROM ESTIMATED_YEARLY_SALES ES  \n" +
            "  WHERE  ES.REQUEST_NUMBER_IF = :REQ_NO \n" +
            "  AND ES.LICENSE_NUMBER_IF = :LIC_NO),0) yearlySalesCY  -- قيمة المبيعات السنوية  \n" +
            "     , \n" +
            "     nvl(( \n" +
            "     \t\tSELECT \n" +
            "\t\t\t\t\tnvl(PROJECT_PROFIT.PROJECT_REVENUE,0)- \n" +
            "\t\t\t\t\tnvl(PROJECT_PROFIT.INTEREST_ON_LOAN,0)- \n" +
            "\t\t\t\t\tnvl(PROJECT_PROFIT.ROYALTIES,0)  \n" +
            "\t\tFROM \tPROJECT_PROFIT \n" +
            "\t\tWHERE REQUEST_NUMBER_IF = :REQ_NO \n" +
            "\t\t\tAND LICENSE_NUMBER_IF = :LIC_NO),0 ) indProfit   --صافي ارباح المشروع \n" +
            "       \n" +
            "      , \n" +
            "       \n" +
            "      nvl( \n" +
            "        (SELECT \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_BUILD_CONST_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_EQUIP_AFTER_INSTAL_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_AIR_COND_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_OF_OFF_FUR_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_OF_FUR_FOR_WAHOUSE_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_OF_EXT_TRANSP_CY,0)+ \n" +
            "\t\t\t\t\t\tNVL(YEARLY_DEPRECIATION.DEP_INT_TRANSP_CY,0)   \n" +
            "\t\t\t\t\t\tFROM YEARLY_DEPRECIATION \n" +
            "\t\t\t\t\t\t   WHERE \n" +
            "\t\t\t\t\t REQUEST_NUMBER_IF = :REQ_NO and operation<>'D' \n" +
            "\t\t\t\t\t \tAND LICENSE_NUMBER_IF = :LIC_NO),0)  yearlyDepreciation -- الاستهلاكات السنوية \n" +
            ", \n" +
            "\t\t NVL(( SELECT \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_BUILD_CONST_CY,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_EQUIP_CY               ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_AIR_COND_CY            ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_FURN_CY                ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_STORE_PREP_CY          ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_EXT_TRANSP_VEH_CY      ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_INT_TRANSP_VEH_CY      ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_SPARTS_CY              ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(OTHER_COST_CY,0)   V_NUM1   \n" +
            "\t \n" +
            "      \t              \n" +
            "\t\t\tFROM FIXED_ASSETS_COST WHERE \n" +
            "\t\tREQUEST_NUMBER_IF = :REQ_NO \n" +
            "\t\tAND LICENSE_NUMBER_IF = :LIC_NO \n" +
            "\t\t      and OPERATION<>'D')  -- TOT_DEPOSIT.V_NUM1 \n" +
            "+ \n" +
            "\t\t\t(\tSELECT \n" +
            "\t\t\t\t\t\t\t \tNVL(COST_OF_STD_TECH_DOC_CY        ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_TRL_CONSL_CY           ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_TRNG_CY                ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_MARKT_PROM_CY          ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(COST_OF_STRT_PROD_PRE_OP_CY    ,0)+ \n" +
            "\t\t\t\t\t\t\t\tNVL(OTHERS_COST_CY                 ,0) \n" +
            "\t\t\t \n" +
            "\t\t\t\tFROM PROJECT_SETUP_COST  \n" +
            "\t\t\t\tWHERE \n" +
            "\t\t\tREQUEST_NUMBER_IF = :REQ_NO \n" +
            "\t\t\tAND LICENSE_NUMBER_IF = :LIC_NO \n" +
            "      and OPERATION<>'D') -- TOT_DEPOSIT.V_NUM2 \n" +
            "+ \n" +
            "\t\t\t(SELECT \tNVL(OPERATING_CAPITAL.COST_OF_SALS_2MONTHS_CY,0)+ \n" +
            "\t\t\t\t\t\t\tNVL(OPERATING_CAPITAL.COST_OF_STO_R_MAT_3MONTHS_CY,0) \n" +
            "\t\t\tFROM \t \tOPERATING_CAPITAL \n" +
            "\t\t\tWHERE \n" +
            "\t\t\t\tREQUEST_NUMBER_IF = :REQ_NO \n" +
            "\t\t\t\tAND LICENSE_NUMBER_IF = :LIC_NO \n" +
            "         and OPERATION<>'D'),0) totDeposit -- TOT_DEPOSIT.V_NUM3  اجمالي الاستثمارات \n" +
            " \n" +
            "      , \n" +
            "        nvl((SELECT   \n" +
            "  SUM(NVL(WK.NO_OF_MALE,0)+NVL(WK.NO_OF_F_MALE,0))  \n" +
            "  FROM PROPOSED_MANPOWER WK \n" +
            "  WHERE \n" +
            "   WK.REQUEST_NUMBER_IF = :REQ_NO  \n" +
            "  AND OPERATION <>'D' \n" +
            "    AND MANP_CAT IN(2,6) \n" +
            "  AND LICENSE_NUMBER_IF = :LIC_NO \n" +
            "   AND WK.MANP_TYPE = 1 ),0) workerNos --عدد العاملين \n" +
            " , (SELECT b.estim_tot_investment_cy FROM BREAKEVEN_POINT b where b.license_number_if=:LIC_NO and b.request_number_if=:REQ_NO) as estimTotInvestmentCy " +
            " \n" +
            "     from dual ",nativeQuery = true)
   BreakevenPointCustom getBreakEvenPointCustomEntity(@Param("REQ_NO") BigDecimal requestNumberId,@Param("LIC_NO") BigDecimal licenseNumber);

}
