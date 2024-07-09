package com.feas.persistence.repository;

import com.feas.domain.entity.FeasibilityPendingVw;
import com.feas.domain.entity.UpdateFeasRemarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpdateFeasRemarksRepository extends JpaRepository<UpdateFeasRemarks,Long> {

    public List<UpdateFeasRemarks> findByRequestNumberIfAndLicenseNumberIf(Long requestNumberIf, Long licenseNumberIf);

}
