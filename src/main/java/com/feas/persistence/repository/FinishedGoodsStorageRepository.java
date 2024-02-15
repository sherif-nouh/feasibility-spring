package com.feas.persistence.repository;

import com.feas.domain.entity.FinishedGoodsStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٠٨/٠٢/٢٠٢٣
 */
public interface FinishedGoodsStorageRepository extends JpaRepository<FinishedGoodsStorage,Long> {

    @Query("from FinishedGoodsStorage p where p.requestNumberIf=:requestNumberId and p.operation <> 'D' order by p.sno")
    List<FinishedGoodsStorage> getAllFinishedGoodsStorageByRequestNumber(@Param("requestNumberId") BigDecimal requestNumberId);

    @Query("from FinishedGoodsStorage p where p.requestNumberIf=:requestNumberId and licenseNumberIf=:licenseNumberIf and p.operation <> 'D'   order by p.sno")
    List<FinishedGoodsStorage> getAllFinishedGoodsStorageByReqIdAndLicNo(@Param("requestNumberId") BigDecimal requestNumberId,@Param("licenseNumberIf") BigDecimal licenseNumberIf);

    @Query(value = "select SUM(NVL(FinishedGoodsStorage.AREA_FOR_STORAGE_NR,0)) grandTotal  \n" +
        "from FINISHED_GOODS_STORAGE FinishedGoodsStorage   \n" +
        "where FINISHEDGOODSSTORAGE.REQUEST_NUMBER_IF=:requestNumberId \n " +
        "AND   FINISHEDGOODSSTORAGE.OPERATION <> 'D' \n " +
        "group by  FINISHEDGOODSSTORAGE.REQUEST_NUMBER_IF ",nativeQuery = true)
    BigDecimal getGrandTotal(@Param("requestNumberId") BigDecimal requestNumberId);


    @Query(value = "select NVL(t.IND_REG_NR,0)/100 * SUM(NVL(FinishedGoodsStorage.AREA_FOR_STORAGE_NR,0)) totalCal  \n" +
            "from FINISHED_GOODS_STORAGE FinishedGoodsStorage ,temp_request t     \n" +
            "where FINISHEDGOODSSTORAGE.REQUEST_NUMBER_IF=:requestNumberId    \n" +
            "AND FINISHEDGOODSSTORAGE.REQUEST_NUMBER_IF=T.REQUEST_NUMBER_ID   \n" +
            "AND FINISHEDGOODSSTORAGE.OPERATION<> 'D' \n" +
            "group by  FINISHEDGOODSSTORAGE.REQUEST_NUMBER_IF,t.IND_REG_NR ",nativeQuery = true)
    BigDecimal getTotalCal(@Param("requestNumberId") BigDecimal requestNumberId);
    @Query(value = "select SUM(NVL(FinishedGoodsStorage.AREA_FOR_STORAGE_NR,0)) +NVL(t.IND_REG_NR,0)/100 * SUM(NVL(FinishedGoodsStorage.AREA_FOR_STORAGE_NR,0)) allTotal  \n" +
            "from FINISHED_GOODS_STORAGE FinishedGoodsStorage ,temp_request t     \n" +
            "where FINISHEDGOODSSTORAGE.REQUEST_NUMBER_IF=:requestNumberId    \n" +
            "AND FINISHEDGOODSSTORAGE.REQUEST_NUMBER_IF=T.REQUEST_NUMBER_ID  \n" +
            "AND  FINISHEDGOODSSTORAGE.OPERATION <> 'D' \n" +
            "group by  FINISHEDGOODSSTORAGE.REQUEST_NUMBER_IF,t.IND_REG_NR",nativeQuery = true)
   BigDecimal getAllTotal(@Param("requestNumberId") BigDecimal requestNumberId);
}
