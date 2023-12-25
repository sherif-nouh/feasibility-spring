package com.feas.persistence.repository;

import com.feas.domain.entity.OperatingCapital;
import com.feas.domain.entity.dto.OperatingCapitalROV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
public interface OperatingCapitalRepository extends JpaRepository<OperatingCapital, BigDecimal> {

    @Query(value = """
             select 
            (SELECT         (NVL(SUM((nvl(proposed_manpower.NO_OF_MALE,0)+ 
                                    nvl(proposed_manpower.NO_OF_F_MALE,0))* 
                                   nvl(proposed_manpower.MONTHLY_SAL_CY,0)*12),0)*1.1)/6   
                        FROM             proposed_manpower 
                       WHERE          REQUEST_NUMBER_IF  = :requestNumberId 
                       AND                OPERATION<>'D') costOfSals2MonthsCy  -- مخزون مواد أولية لمدة 3 شهور     
                       ,  
                        (SELECT     (ROUND(NVL(T_VAL_MAT_PROD_CIF_CY,0))/4)  
                   --INTO         :OPERATING_CAPITAL.COST_OF_STO_R_MAT_3MONTHS_CY 
                   FROM         TECHNICAL_STUDY_SUMMARY 
                    WHERE      REQUEST_NUMBER_IF  = :requestNumberId) costOfStoRMat3MonthsCy --اجور و رواتب لمدة شهرين 
                    , 
                     
                    --   COST_OF_SALS_2MONTHS_CY+COST_OF_STO_R_MAT_3MONTHS_CY 
                        ( 
                        SELECT NVL(COST_OF_BUILD_CONST_CY,0)+ 
                                            NVL(COST_OF_EQUIP_CY               ,0)+ 
                                            NVL(COST_OF_AIR_COND_CY            ,0)+ 
                                            NVL(COST_OF_FURN_CY                ,0)+ 
                                            NVL(COST_OF_STORE_PREP_CY          ,0)+ 
                                           NVL(COST_OF_EXT_TRANSP_VEH_CY      ,0)+ 
                                            NVL(COST_OF_INT_TRANSP_VEH_CY      ,0)+ 
                                            NVL(COST_OF_SPARTS_CY              ,0)+ 
                                            NVL(OTHER_COST_CY,0)                  
                        FROM     FIXED_ASSETS_COST  
                       WHERE    REQUEST_NUMBER_IF = :requestNumberId 
                        )  fixAssetCostCY  -- الأصول الثابته 
                        , 
                         
                        ( 
                       SELECT     NVL(COST_OF_STD_TECH_DOC_CY        ,0)+ 
                                        NVL(COST_OF_TRL_CONSL_CY           ,0)+ 
                                       NVL(COST_OF_TRNG_CY                ,0)+ 
                                        NVL(COST_OF_MARKT_PROM_CY          ,0)+ 
                                        NVL(COST_OF_STRT_PROD_PRE_OP_CY    ,0)+ 
                                        NVL(OTHERS_COST_CY                 ,0) 
                     
                        FROM PROJECT_SETUP_COST  
                        WHERE    REQUEST_NUMBER_IF = :requestNumberId 
                        )  projectSetupCostCY --مصاريف التأسيس  
             ,
             (select (NVL(SUM((nvl(proposed_manpower.NO_OF_MALE,0)+ 
                                    nvl(proposed_manpower.NO_OF_F_MALE,0))* 
                                    nvl(proposed_manpower.MONTHLY_SAL_CY,0)*12),0)*1.1)/6    
                        FROM             proposed_manpower 
                        WHERE          REQUEST_NUMBER_IF  = :requestNumberId 
                        AND                OPERATION<>'D')  
                    + 
                        (SELECT     (ROUND(NVL(T_VAL_MAT_PROD_CIF_CY,0))/4)  
                    FROM         TECHNICAL_STUDY_SUMMARY 
                    WHERE      REQUEST_NUMBER_IF  = :requestNumberId)  operatingCapitalTotal
            from DUAL """,nativeQuery = true)
    OperatingCapitalROV getOperatingCapitalRov(@Param("requestNumberId") BigDecimal requestNumberId);
}
