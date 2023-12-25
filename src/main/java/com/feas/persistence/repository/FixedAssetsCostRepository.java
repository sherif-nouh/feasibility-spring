package com.feas.persistence.repository;

import com.feas.domain.entity.dto.FixedAssetsCostReadOnlyFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.feas.domain.entity.FixedAssetsCost;
import com.feas.domain.entity.FixedAssetsCostPK;

import java.math.BigDecimal;

@Repository
public interface FixedAssetsCostRepository extends JpaRepository<FixedAssetsCost, FixedAssetsCostPK> {

    @Query(value = """
             SELECT FixedAssetsCost.PROJECT_NUMBER_IF as projectNumberIf, 
                   FixedAssetsCost.REQUEST_NUMBER_IF as requestNumberIf , 
                   FixedAssetsCost.COST_OF_BUILD_CONST_CY costOfBuildConstCy , 
                   FixedAssetsCost.COST_OF_EQUIP_CY as costOfEquipCy, 
                  FixedAssetsCost.COST_OF_AIR_COND_CY as costOfAirCondCy, 
                   FixedAssetsCost.COST_OF_FURN_CY as costOfFurnCy, 
                   FixedAssetsCost.COST_OF_STORE_PREP_CY as costofstoreprepcy , 
                  FixedAssetsCost.COST_OF_EXT_TRANSP_VEH_CY as costOfExtTranspVehCy, 
                   FixedAssetsCost.COST_OF_INT_TRANSP_VEH_CY as costOfIntTranspVehCy ,
                   FixedAssetsCost.COST_OF_SPARTS_CY as costOfSpartsCy, 
                   FixedAssetsCost.OTHER_COST_CY as otherCostCy ,
                   FixedAssetsCost.USER_NAME as userName, 
                   FixedAssetsCost.OPERATION as operation, 
                   FixedAssetsCost.DATE_STAMP as dateStamp , 
                   FixedAssetsCost.LICENSE_NUMBER_IF as licenseNumberIf , 
                  
                   (nvl(FixedAssetsCost.COST_OF_BUILD_CONST_CY, 0)+ 
                   nvl(FixedAssetsCost.COST_OF_EQUIP_CY, 0)+ 
                   nvl(FixedAssetsCost.COST_OF_AIR_COND_CY, 0)+
                   nvl(FixedAssetsCost.COST_OF_FURN_CY, 0)+ 
                   nvl(FixedAssetsCost.COST_OF_STORE_PREP_CY, 0)+
                   nvl(FixedAssetsCost.COST_OF_EXT_TRANSP_VEH_CY, 0)+ 
                   nvl(FixedAssetsCost.COST_OF_INT_TRANSP_VEH_CY, 0)+ 
                  nvl(FixedAssetsCost.COST_OF_SPARTS_CY, 0)) fixedAssetsTotalCost, 
                   
                   ROUND(NVL(TechnicalStudySummery.T_EXP_EQUIP_AFTER_INSTAL_CY, 0)) equipmentCost ,
                   
                  costOfbuild.Cbuild , 
                   costOftrans.TVALI , 
                   costOftrans.TVALE 
             FROM (SELECT * FROM FIXED_ASSETS_COST WHERE REQUEST_NUMBER_IF = :requestNumberId) fixedAssetsCost ,
                 (SELECT * FROM TECHNICAL_STUDY_SUMMARY WHERE REQUEST_NUMBER_IF= :requestNumberId )TechnicalStudySummery, 
             
              (SELECT ROUND(BC.TOT+(NVL(TO_OWNER_CIVILID, 0)*NVL(CERTIFICATE_PLOT_NO, 0))+((BC.TOT*NVL(RENT_CONTRACT_IF, 0))/100)) cbuild 
               FROM (select * from TEMP_REQUEST where REQUEST_NUMBER_ID = :requestNumberId) TEMP_REQUEST,  
                (SELECT SUM(NVL(AREA_NR, 0)*NVL(COST_CY, 0)) TOT 
                  FROM INDUSTRIAL_PLOT_BUILD_COST 
                  WHERE REQUEST_NUMBER_IF = :requestNumberId 
                    AND OPERATION <> 'D') BC )costOfbuild, 
             
              (SELECT SUM(DECODE(VEH_TYPE, 1, NVL(PROPOSED_CARRIER.UNIT_PRICE_CY, 0)*NVL(PROPOSED_CARRIER.QUANTITY_NR, 0))) tvali, 
                      SUM(DECODE(VEH_TYPE, 2, NVL(PROPOSED_CARRIER.UNIT_PRICE_CY, 0)*NVL(PROPOSED_CARRIER.QUANTITY_NR, 0))) tvale  
               FROM PROPOSED_CARRIER 
              WHERE REQUEST_NUMBER_IF = :requestNumberId 
                 AND OPERATION <> 'D') costOftrans  """, nativeQuery = true)
    FixedAssetsCostReadOnlyFields getAllFexedAssetCostReadOnlyFields(@Param("requestNumberId") Long requestNumberId);

}
