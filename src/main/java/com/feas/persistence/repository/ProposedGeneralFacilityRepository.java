package com.feas.persistence.repository;

import com.feas.domain.entity.ProposedGeneralFacility;
import com.feas.domain.entity.ProposedStock;
import com.feas.domain.entity.dto.SumGeneralFacility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٢/٢٠٢٣
 */
public interface ProposedGeneralFacilityRepository extends JpaRepository<ProposedGeneralFacility,Long> {
    @Query("from ProposedGeneralFacility ps where ps.requestNumberIf=:requestNumberId and ps.operation <> 'D' order by ps.sno")
    List<ProposedGeneralFacility> getAllProposedGeneralFacilityByRequestNumber(@Param("requestNumberId") BigDecimal requestNumberId);
    @Query("from ProposedGeneralFacility ps where ps.requestNumberIf=:requestNumberId and ps.operation <> 'D' order by ps.sno")
    Page<ProposedGeneralFacility> getAllProposedGeneralFacilityByRequestNumberAsPage(@Param("requestNumberId") BigDecimal requestNumberId, Pageable page);


    @Query(value = "SELECT DISTINCT (  SELECT  SUM(nvl(proposedgeneralfacility.quantity_nr, 0) * nvl(proposedgeneralfacility.unit_cost_cy, 0) / 1000) as totalValue  from general_facility g,  proposed_general_facility proposedgeneralfacility, unit u WHERE proposedgeneralfacility.request_number_if = :requestNumberId   AND g.gen_fac_code_id = proposedgeneralfacility.gen_fac_code_if   AND g.unit_code_if = u.unit_code_id AND proposedgeneralfacility.operation <> 'D'  AND gen_fac_type_if = 2  ) as totalNonProductive , (    SELECT  SUM(nvl(proposedgeneralfacility.quantity_nr, 0) * nvl(proposedgeneralfacility.unit_cost_cy, 0) / 1000) as totalValue1  from   general_facility g,  proposed_general_facility proposedgeneralfacility ,  unit u WHERE " +
            "            proposedgeneralfacility.request_number_if = :requestNumberId \n" +
            "            AND g.gen_fac_code_id = proposedgeneralfacility.gen_fac_code_if \n" +
            "            AND g.unit_code_if = u.unit_code_id \n" +
            "            AND proposedgeneralfacility.operation <> 'D' \n" +
            "            AND gen_fac_type_if = 1 \n" +
            "    ) as totalProductive, \n" +
            "    ( \n" +
            "        SELECT \n" +
            "            SUM(nvl(proposedgeneralfacility.quantity_nr, 0) * nvl(proposedgeneralfacility.unit_cost_cy, 0) / 1000) as totalValue2 \n" +
            "        FROM general_facility          g, \n" +
            "            proposed_general_facility  proposedgeneralfacility \n" +
            "        WHERE   proposedgeneralfacility.request_number_if = :requestNumberId \n" +
            "            AND g.gen_fac_code_id = proposedgeneralfacility.gen_fac_code_if \n" +
            "            AND proposedgeneralfacility.operation <> 'D'  ) as totalGeneralFacility ,   proposedgeneralfacility.request_number_if as requestNumberIf \n" +
            " FROM  proposed_general_facility  proposedgeneralfacility  WHERE    proposedgeneralfacility.request_number_if = :requestNumberId AND proposedgeneralfacility.operation <> 'D' " ,nativeQuery = true)
    SumGeneralFacility getSumGeneralFacility(@Param("requestNumberId") BigDecimal requestNumberId);



}
