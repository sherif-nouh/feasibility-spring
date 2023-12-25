package com.feas.service.impl;

import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.EconomicalStudySummaryPK;
import com.feas.persistence.repository.EconomicalStudySummaryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EconomicalStudySummaryService {
    private final EconomicalStudySummaryRepository economicalStudySummaryRepository;

    public EconomicalStudySummaryService(EconomicalStudySummaryRepository economicalStudySummaryRepository) {
        this.economicalStudySummaryRepository = economicalStudySummaryRepository;
    }


    public EconomicalStudySummary getEconomicalStudySummaryOrCreateNew(long requestNumberIf,long licenseNumberIf){
        EconomicalStudySummaryPK ess= new EconomicalStudySummaryPK();
        ess.setLicenseNumberIf(licenseNumberIf);
        ess.setProjectNumberIf(licenseNumberIf);
        ess.setRequestNumberIf(requestNumberIf);
        Optional<EconomicalStudySummary> byId = economicalStudySummaryRepository.findById(ess);
        if(byId.isPresent()){
            return byId.get();
        }
        EconomicalStudySummary newRec= new EconomicalStudySummary();
        newRec.setLicenseNumberIf(licenseNumberIf);
        newRec.setProjectNumberIf(licenseNumberIf);
        newRec.setRequestNumberIf(requestNumberIf);

        return newRec;
    }

    public EconomicalStudySummary save(EconomicalStudySummary economicalStudySummary){
        return economicalStudySummaryRepository.save(economicalStudySummary);
    }

}
