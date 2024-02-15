package com.feas.persistence.repository;

import com.feas.domain.entity.LicenseProduction;
import com.feas.domain.entity.UpdateFeasRemarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseProductionRepository extends JpaRepository<LicenseProduction,Long> {

    public List<LicenseProduction> findByLicenseNumberIf(Long licenseNumberIf);

}
