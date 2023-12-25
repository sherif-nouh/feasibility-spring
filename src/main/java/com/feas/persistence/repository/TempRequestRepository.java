package com.feas.persistence.repository;

import com.feas.domain.entity.dto.ProposedProjectTempRequest;
import com.feas.domain.entity.dto.ProposedProjectTempRequestDTO;
import com.feas.domain.entity.lookups.TempRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TempRequestRepository extends JpaRepository<TempRequest,Long> {

    @Query(value = "SELECT     \n" +
            "    REQUEST_NUMBER_ID,     \n" +
            "    NVL(tr.IND_REG_NR, 0) / 100 indRegNrPer,     \n" +
            "    NVL(tr.DAYS_GIVEN, 0) / 100 daysGivenPer,     \n" +
            "    NVL(tr.ADDITIONAL_AREA, 0) / 100 additionAreaPer,     \n" +
            "    NVL(tr.CONTRACT_NO,0)/100 contNoPer ,  \n" +
            "    tr.CONTRACT_NO contno  \n" +
            "FROM     \n" +
            "    TEMP_REQUEST tr     \n" +
            "WHERE     \n" +
            "    REQUEST_NUMBER_ID = :req_no AND LICENSE_NUMBER_IF = :lic_no"
            ,nativeQuery = true)
    ProposedProjectTempRequest getTempRequestData(@Param("lic_no") Long licenseNumberIf, @Param("req_no") Long requestNumberIf);
    Optional<TempRequest> findByRequestNumberIdAndLicenseNumberIf(Long requestNumberIf, Long licenseNumberIf );
    Optional<TempRequest> findByRequestNumberId(Long requestNumberIf );

}
