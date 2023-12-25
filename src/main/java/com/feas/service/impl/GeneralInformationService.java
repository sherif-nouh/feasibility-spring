package com.feas.service.impl;

import com.feas.domain.entity.FinishedGoodsStorage;
import com.feas.domain.entity.GeneralInformation;
import com.feas.domain.entity.dto.GeneralInformationDTO;
import com.feas.persistence.repository.GeneralInformationRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneralInformationService {

    private final GeneralInformationRepository generalInformationRepository;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;

    public GeneralInformationService(GeneralInformationRepository generalInformationRepository, ServiceObjectMapperImpl modelMapper) {
        this.generalInformationRepository = generalInformationRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<GeneralInformation> getById(Long id){
        return generalInformationRepository.findById(id);
    }

    public GeneralInformation updateGeneralInformation(GeneralInformationDTO generalInformationDTO) {
        return generalInformationRepository.findById(generalInformationDTO.getLicenseNumberIf())
                .map(generalInformation -> {
                    GeneralInformation map = modelMapper.map(generalInformationDTO, GeneralInformation.class);
                    map.setLicenseNumberIf(generalInformationDTO.getLicenseNumberIf());
                   // map.setAction("U");
                    generalInformationRepository.save(map);
                    return map;// "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return null;
                });
    }
}
