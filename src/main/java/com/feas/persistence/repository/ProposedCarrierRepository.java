package com.feas.persistence.repository;

import com.feas.domain.entity.ProposedCarrier;
import com.feas.domain.entity.dto.ProposedCarrierDTO;
import com.feas.domain.entity.dto.ProposedCarrierSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Transactional

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


    @Modifying
    @Query(value = " update proposed_carrier pr set pr.operation='D' where pr.PROPOSED_CARRIER_ID=:proposedCarrierId ",nativeQuery = true)
    int deleteFromProposedCarrier(Long proposedCarrierId);

    @Modifying
    @Query(value = """
             update proposed_carrier pr set 
                                            pr.ACTUAL_REMARKS_TX=:actualRemarksTx,
                                            pr.APPROVED_REMARKS_TX=:approvedRemarksTx,
                                            pr.EXCHANGE_RATE_CY=:exchangeRateCy,
                                            pr.FOREIGN_CODE_IF=:foreignCodeIf,
                                            pr.LICENSE_NUMBER_IF=:licenseNumberIf,
                                            pr.MANUF_CTRY_CODE_IF=:manufCtryCodeIf,
                                            pr.OPERATION='U',
                                            pr.DATE_STAMP=:dateStamp,
                                            pr.DATE_DT=:dateStamp,
                                            pr.PROJECT_NUMBER_IF=:projectNumberIf,
                                            pr.PROPOSED_REMARKS_BY=:proposedRemarksBy,
                                            pr.QUANTITY_ACTUAL=:quantityActual,
                                            pr.QUANTITY_APPROVED=:quantityApproved,
                                            pr.QUANTITY_NR=:quantityNr,
                                            pr.REMARKS_ACTUAL_BY=:remarksActualBy,
                                            pr.REMARKS_APPROVED_BY=:remarksApprovedBy,
                                            pr.REMARKS_PROPOSED_BY=:remarksProposedBy,
                                            pr.REQUEST_NUMBER_IF=:requestNumberIf,
                                            pr.SERIAL_NUMBER_ID=:serialNumberId,
                                            pr.UNIT_PRICE_CY=:unitPriceCy,
                                            pr.USER_NAME=:userName,
                                            pr.VEH_CODE_IF=:vehCodeIf,
                                            pr.VEH_TYPE=:vehType,
                                            pr.VEHICAL_NAME=:vehicalName
             where pr.PROPOSED_CARRIER_ID=:proposedCarrierId """,nativeQuery = true)
    int updateFromProposedCarrier(
                                  @Param("proposedCarrierId") Long proposedCarrierId,
                                  @Param("actualRemarksTx") String actualRemarksTx,
                                  @Param("approvedRemarksTx") String approvedRemarksTx,
                                  @Param("exchangeRateCy") BigDecimal exchangeRateCy,
                                  @Param("foreignCodeIf") BigDecimal foreignCodeIf,
                                  @Param("licenseNumberIf") Long licenseNumberIf,
                                  @Param("manufCtryCodeIf") BigDecimal manufCtryCodeIf,
                                  @Param("projectNumberIf") Long projectNumberIf,
                                  @Param("proposedRemarksBy") String proposedRemarksBy,
                                  @Param("quantityActual") BigDecimal quantityActual,
                                  @Param("quantityApproved") BigDecimal quantityApproved,
                                  @Param("quantityNr") BigDecimal quantityNr,
                                  @Param("remarks") String remarks,
                                  @Param("remarksActualBy") String remarksActualBy,
                                  @Param("remarksApprovedBy") String remarksApprovedBy,
                                  @Param("remarksProposedBy") String remarksProposedBy,
                                  @Param("requestNumberIf") Long requestNumberIf,
                                  @Param("serialNumberId") BigDecimal serialNumberId,
                                  @Param("unitPriceCy") BigDecimal unitPriceCy,
                                  @Param("userName") String userName,
                                  @Param("vehCodeIf") BigDecimal vehCodeIf,
                                  @Param("vehType") BigDecimal vehType,
                                  @Param("vehicalName") String vehicalName,
                                  @Param("dateStamp") Date dateStamp);
}
