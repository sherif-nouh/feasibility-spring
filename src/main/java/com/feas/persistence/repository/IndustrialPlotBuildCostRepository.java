package com.feas.persistence.repository;

import com.feas.domain.entity.IndustrialPlotBuildCost;
import com.feas.domain.entity.ProposedGeneralFacility;
import com.feas.domain.entity.dto.CalculateIndustrialCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٠٧/٠٢/٢٠٢٣
 */
public interface IndustrialPlotBuildCostRepository extends JpaRepository<IndustrialPlotBuildCost,Long> {


    @Query("from IndustrialPlotBuildCost ps where ps.requestNumberIf=:requestNumberId and ps.operation <> 'D' order by ps.sno")
    List<IndustrialPlotBuildCost> getAllIndustrialPlotBuildCostByRequestNumber(@Param("requestNumberId") BigDecimal requestNumberId);


    @Query(value = " select sum(nvl(IndustrialPlotBuildCost.COST_CY,0)*nvl(IndustrialPlotBuildCost.AREA_NR,0)) sumTotalArea ," +
            " sum(nvl(IndustrialPlotBuildCost.AREA_NR,0)) sumSqm , \n" +
            "NVL(t.TO_OWNER_CIVILID,0)*NVL(t.CERTIFICATE_PLOT_NO,0) totalLandExp,  \n" +
            "sum(nvl(IndustrialPlotBuildCost.COST_CY,0)*nvl(IndustrialPlotBuildCost.AREA_NR,0))*(NVL(t.RENT_CONTRACT_IF,0)/100) supervisionExp,  \n" +
            "sum(nvl(IndustrialPlotBuildCost.COST_CY,0)*nvl(IndustrialPlotBuildCost.AREA_NR,0))+NVL(t.TO_OWNER_CIVILID,0)*NVL(t.CERTIFICATE_PLOT_NO,0)  \n" +
            "+sum(nvl(IndustrialPlotBuildCost.COST_CY,0)*nvl(IndustrialPlotBuildCost.AREA_NR,0))*(NVL(t.RENT_CONTRACT_IF,0)/100) grandTotal ,INDUSTRIALPLOTBUILDCOST.REQUEST_NUMBER_IF  requestNumberIf \n" +
            "from INDUSTRIAL_PLOT_BUILD_COST IndustrialPlotBuildCost,temp_request t  \n" +
            "where INDUSTRIALPLOTBUILDCOST.REQUEST_NUMBER_IF=:requestNumberId  \n" +
            "and INDUSTRIALPLOTBUILDCOST.REQUEST_NUMBER_IF=T.REQUEST_NUMBER_ID  \n" +
            "AND INDUSTRIALPLOTBUILDCOST.OPERATION <> 'D' \n" +
            "group by t.CERTIFICATE_PLOT_NO,t.TO_OWNER_CIVILID,t.RENT_CONTRACT_IF,INDUSTRIALPLOTBUILDCOST.REQUEST_NUMBER_IF " ,nativeQuery = true)
    CalculateIndustrialCost getCalculateIndustrialCost(@Param("requestNumberId") BigDecimal requestNumberId);


    @Procedure
    void PLOT_BUILD_COST(BigDecimal requestNumberIf);
}
