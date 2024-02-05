package com.feas.service.impl;


import com.feas.domain.entity.*;
import com.feas.domain.entity.dto.EstimatedYearlySaleDTO;
import com.feas.persistence.repository.IntroductionRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ١٦/٠٢/٢٠٢٣
 */

@Service
public class IntroducationService {

    private final IntroductionRepository introductionRepository;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;

    public IntroducationService(IntroductionRepository introRepository, ServiceObjectMapperImpl modelMapper) {
        this.introductionRepository = introRepository;
        this.modelMapper = modelMapper;
    }
    public List<Introduction> getIntroductionOrCreateNew(BigDecimal requestNumberIf, BigDecimal licenseNumberIf){

       return (introductionRepository.getAllIntroductionByRequestNumber(requestNumberIf));




    }
    public Introduction saveIntroduction(Introduction introduction){

        Introduction ess= new Introduction();
        ess.setLicenseNumberIf(introduction.getLicenseNumberIf());
        ess.setProjectNumberIf(introduction.getLicenseNumberIf());
        ess.setRequestNumberIf(introduction.getRequestNumberIf());
        Optional<Introduction> byId = introductionRepository.findById(introduction.getIntroductionId());
        if(byId.isPresent()){
            byId.get().setRemarks(introduction.getRemarks());

            byId.get().setOperation("U");

            return introductionRepository.save(byId.get());
        }else {
            Introduction newIntroduction= new Introduction();
            newIntroduction.setLicenseNumberIf(introduction.getLicenseNumberIf());
            newIntroduction.setProjectNumberIf(introduction.getLicenseNumberIf());
            newIntroduction.setRequestNumberIf(introduction.getRequestNumberIf());

            newIntroduction.setOperation("I");
            newIntroduction.setDateStamp(new Date());

            byId.get().setRemarks(introduction.getRemarks());
            return introductionRepository.save(newIntroduction);
        }
    }

    public Introduction save(Introduction economicalStudySummary){
        return introductionRepository.save(economicalStudySummary);
    }
    public Optional<Introduction> findById(Long id) {
        return  introductionRepository.findById(id);
    }






}
