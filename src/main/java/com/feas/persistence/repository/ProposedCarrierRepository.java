package com.feas.persistence.repository;

import com.feas.domain.entity.ProposedCarrier;
import com.feas.domain.entity.dto.ProposedCarrierSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProposedCarrierRepository extends JpaRepository<ProposedCarrier,Long> {
    @Query("select p from ProposedCarrier p where p.operation != 'D' and "
            + " p.licenseNumberIf=:licenseNumberIf and p.requestNumberIf=:requestNumberIf order by p.serialNumberId asc")
    List<ProposedCarrier> queryAll(@Param("licenseNumberIf") Long licenseNumberIf,@Param("requestNumberIf") Long requestNumberIf);

    @Query(value = "SELECT\n" +
            "    a1.request_number_if                                     requestNumberIf,\n" +
            "    a1.license_number_if                                     licenseNumberIf,\n" +
            "    SUM(\n" +
            "        CASE\n" +
            "            WHEN a1.veh_type <> 2 THEN\n" +
            "                nvl(nvl(a1.unit_price_cy, 0) * nvl(a1.quantity_nr, 0), 0)\n" +
            "            ELSE\n" +
            "                0\n" +
            "        END\n" +
            "    )                                                        AS intTransp,\n" +
            "    SUM(\n" +
            "        CASE\n" +
            "            WHEN a1.veh_type <> 1 THEN\n" +
            "                nvl(nvl(a1.unit_price_cy, 0) * nvl(a1.quantity_nr, 0), 0)\n" +
            "            ELSE\n" +
            "                0\n" +
            "        END\n" +
            "    )                                                        AS extTransp,\n" +
            "    SUM((nvl(a1.unit_price_cy, 0) * nvl(a1.quantity_nr, 0))) AS sumTotalValue\n" +
            "FROM\n" +
            "    proposed_carrier a1\n" +
            "WHERE\n" +
            "        a1.request_number_if = :requestId\n" +
            "    AND a1.operation <> 'D'\n" +
            "GROUP BY\n" +
            "    request_number_if,\n" +
            "    license_number_if",nativeQuery = true)
    ProposedCarrierSummary getProposedCarrierInternalExternalTransport(@Param("requestId") Long requestNumberIf);




}
