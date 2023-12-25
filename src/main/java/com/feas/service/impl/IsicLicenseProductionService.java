package com.feas.service.impl;

import com.feas.domain.entity.IsicLicenseProduction;
import com.feas.domain.entity.lookups.RemarksTech;
import com.feas.persistence.repository.lookup.IsicLicenseProductionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٢٢/٠٦/٢٠٢٣
 */
@Service
public class IsicLicenseProductionService {

    private final IsicLicenseProductionRepository isicLicenseProductionRepository;

    public IsicLicenseProductionService(IsicLicenseProductionRepository isicLicenseProductionRepository) {
        this.isicLicenseProductionRepository = isicLicenseProductionRepository;
    }


    public IsicLicenseProduction saveNew(IsicLicenseProduction isicLicenseProduction){
        isicLicenseProduction.setActionDate(new Date());
        return isicLicenseProductionRepository.save(isicLicenseProduction);
    }

    public IsicLicenseProduction deleteRecord(IsicLicenseProduction isicLicenseProduction) {
        isicLicenseProduction.setOperation("D");
        isicLicenseProduction.setAction("D");

        return isicLicenseProductionRepository.save(isicLicenseProduction);
    }
}
