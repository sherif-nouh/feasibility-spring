package com.feas.service.impl;

import com.feas.domain.entity.ProposedGeneralFacility;
import com.feas.domain.entity.dto.ProposedProjectTempRequest;
import com.feas.domain.entity.dto.TempRequestDTO;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.persistence.repository.TempRequestRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٠٨/٠٢/٢٠٢٣
 */
@Service
public class TempRequestService {
    private final TempRequestRepository tempRequestRepository;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;
    public TempRequestService(TempRequestRepository tempRequestRepository, ServiceObjectMapperImpl modelMapper) {
        this.tempRequestRepository = tempRequestRepository;
        this.modelMapper = modelMapper;
    }

    public ProposedProjectTempRequest getProposedProjectTempRequest(Long licenseNumberIf,Long requestNumberIf){
        return tempRequestRepository.getTempRequestData(licenseNumberIf,requestNumberIf);
    }

    public Optional<TempRequest> getTempRequestByRequestNumberAndLicence(Long requestNumberIf, Long licenseNumberIf) {
        return tempRequestRepository.findByRequestNumberIdAndLicenseNumberIf( requestNumberIf, licenseNumberIf);
    }

         public TempRequest updateProposedManpower(TempRequestDTO tempRequest) {
             TempRequest map = modelMapper.map(tempRequest, TempRequest.class);
             map.setDateStamp(new Date());
             return tempRequestRepository.save(map);
        }
}
