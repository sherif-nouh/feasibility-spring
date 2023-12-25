package com.feas.service.impl;

import com.feas.domain.entity.FeasbilityRejection;
import com.feas.domain.entity.GeneralInformation;
import com.feas.domain.entity.dto.FeasbilityRejectionDTO;
import com.feas.domain.entity.dto.GeneralInformationDTO;
import com.feas.persistence.repository.FeasbilityRejectionRepository;
import com.feas.persistence.repository.GeneralInformationRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ١٤/٠٢/٢٠٢٣
 */
@Service
public class FeasbilityRejectionService {

    private final FeasbilityRejectionRepository feasbilityRejectionRepository;

    @Autowired
    private final ServiceObjectMapperImpl modelMapper;

    public FeasbilityRejectionService(FeasbilityRejectionRepository feasbilityRejectionRepository, ServiceObjectMapperImpl modelMapper) {
        this.feasbilityRejectionRepository = feasbilityRejectionRepository;
        this.modelMapper = modelMapper;
    }




    public Optional<FeasbilityRejection> getById(Long id){
        return feasbilityRejectionRepository.findById(id);
    }

    public FeasbilityRejection updateFeasbilityRejection(FeasbilityRejectionDTO feasbilityRejectionDTO) {
        return feasbilityRejectionRepository.findById(feasbilityRejectionDTO.getFeasbilityRejectionId())
                .map(feasibilityRejection -> {
                    FeasbilityRejection map = modelMapper.map(feasbilityRejectionDTO, FeasbilityRejection.class);
                    map.setFeasbilityRejectionId(feasbilityRejectionDTO.getFeasbilityRejectionId());
                  //  map.setOperation("U");
                    feasbilityRejectionRepository.save(map);
                    return map;// "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return null;
                });
    }


}
