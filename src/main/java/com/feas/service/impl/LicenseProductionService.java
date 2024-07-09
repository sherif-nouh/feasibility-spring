package com.feas.service.impl;

import com.feas.domain.entity.LicenseProduction;
import com.feas.domain.entity.UpdateFeasRemarks;
import com.feas.persistence.repository.LicenseProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseProductionService {
    @Autowired
    LicenseProductionRepository licProdRepo;

    public List<LicenseProduction> findByLicenseNumberIf(Long licenseNumberIf){
        return licProdRepo.findByLicenseNumberIf(licenseNumberIf);
    }
}
