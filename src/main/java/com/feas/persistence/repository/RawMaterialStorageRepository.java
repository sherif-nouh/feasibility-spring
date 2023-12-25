package com.feas.persistence.repository;

import com.feas.domain.entity.ProposedGeneralFacility;
import com.feas.domain.entity.dto.SumRawMaterial;
import com.feas.domain.entity.dto.SumRawMaterialDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.feas.domain.entity.RawMaterialStorage;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RawMaterialStorageRepository extends JpaRepository<RawMaterialStorage, Long> {


    @Query("select new com.feas.domain.entity.RawMaterialStorage(ps.rawMaterialStorageId," +
            "    ps.addAreaReqNr," +
            "ps.areaReqForStorageNr," +
            "ps.dateStamp," +
            "ps.licenseNumberIf," +
            "ps.materialTypeIf," +
            "ps.methodOfStorTx," +
            "ps.noOfUnitsStoredNr," +
            "ps.operation," +
            "ps.prodOriginIf," +
            "ps.projectNumberIf," +
            "ps.proposedStockFk," +
            "ps.qtyReqStoToKpProdGoNr," +
            "ps.quantityPerYearNr," +
            "ps.rawMatIf," +
            "ps.rawmatReceiveMethodTx," +
            "ps.requestNumberIf," +
            "ps.serialNumberId," +
            "ps.sno," +
            "ps.source," +
            "ps.storPerReqToKpProdGoNr," +
            "ps.storageUnitTx," +
            "ps.unitCodeIf," +
            "ps.userName," +
            "c.countryTx," +
            "m.matNameTx,u.unitDescTx )" +
            " from RawMaterialStorage ps " +
            "join Unit u  join Material m join Country c where u.unitCodeId=ps.unitCodeIf and m.matCodeId=ps.rawMatIf and c.countryCodeId=ps.prodOriginIf and  ps.requestNumberIf=:requestNumberId and ps.operation <> 'D' order by ps.sno")
    List<RawMaterialStorage> getAllRawMaterialByRequestNumber(BigDecimal requestNumberId);

    @Query("from RawMaterialStorage ps where ps.requestNumberIf=:requestNumberId and ps.operation <> 'D' order by ps.sno")
    Page<RawMaterialStorage> getAllRawMaterialStorageByRequestNumberAsPage(@Param("requestNumberId") BigDecimal requestNumberId, Pageable page);


    @Query(value = " select sum(nvl(RAWMATERIALSTORAGE.AREA_REQ_FOR_STORAGE_NR,0)) totalArea ,sum(nvl(RAWMATERIALSTORAGE.AREA_REQ_FOR_STORAGE_NR,0))*NVL(T.DAYS_GIVEN,0)/100 percTotal,  \n" +
            "sum(nvl(RAWMATERIALSTORAGE.AREA_REQ_FOR_STORAGE_NR,0))+sum(nvl(RAWMATERIALSTORAGE.AREA_REQ_FOR_STORAGE_NR,0))*NVL(T.DAYS_GIVEN,0)/100 sumTotalArea,RAWMATERIALSTORAGE.REQUEST_NUMBER_IF  requestNumberIf \n" +
            "from RAW_MATERIAL_STORAGE RawMaterialStorage ,TEMP_REQUEST T   \n" +
            "WHERE RAWMATERIALSTORAGE.REQUEST_NUMBER_IF=T.REQUEST_NUMBER_ID  \n" +
            "AND RAWMATERIALSTORAGE.REQUEST_NUMBER_IF=:requestNumberId  \n" +
            "AND RAWMATERIALSTORAGE.OPERATION<>'D' \n" +
            "group by RAWMATERIALSTORAGE.REQUEST_NUMBER_IF,T.DAYS_GIVEN" ,nativeQuery = true)
    SumRawMaterialDTO getSumRawMaterial(@Param("requestNumberId") BigDecimal requestNumberId);
}
