package com.feas.service.impl;

import com.feas.domain.entity.ProposedCarrier;
import com.feas.domain.entity.ProposedProjectEquipment;
import com.feas.domain.entity.dto.ProposedCarrierDTO;
import com.feas.domain.entity.dto.ProposedCarrierSummary;
import com.feas.persistence.repository.ProposedCarrierRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import com.feas.service.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProposedCarrierService {
    private final ProposedCarrierRepository proposedCarrierRepository;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;
    public ProposedCarrierService(ProposedCarrierRepository proposedCarrierRepository, ServiceObjectMapperImpl modelMapper) {
        this.proposedCarrierRepository = proposedCarrierRepository;
        this.modelMapper = modelMapper;
    }


    public List<ProposedCarrier> queryAll(Long licenseNumberIf, Long requestNumberIf) {
        List<ProposedCarrier> proposedCarriers = proposedCarrierRepository.queryAll(licenseNumberIf, requestNumberIf);
        proposedCarriers.stream().forEach(prop->{
            prop.setTotal(prop.getUnitPriceCy().multiply(prop.getQuantityNr()));
            prop.setQuantityApproved(prop.getQuantityNr());
            prop.setDateStamp(new Date());
           // proposedCarrierRepository.save(prop);
        });
        return proposedCarriers;
    }

    public ProposedCarrierSummary getProposedCarrierInternalExternalTransport(Long requestNumberIf){
        return proposedCarrierRepository.getProposedCarrierInternalExternalTransport(requestNumberIf);
    }






  public ProposedCarrier save(ProposedCarrierDTO proposedCarrier) {
        ProposedCarrier map = modelMapper.map(proposedCarrier, ProposedCarrier.class);
        map.setDateStamp(new Date());
        map.setManufCtry(null);
        map.setVehicalCode(null);
        map.setQuantityApproved(map.getQuantityNr()==null?new BigDecimal(0):map.getQuantityNr());
        proposedCarrier.setVehType(null);
       return proposedCarrierRepository.save(map);
    }

    public Optional<ProposedCarrier> findById(Long id) {
        return proposedCarrierRepository.findById(id);
    }

    public int updateFromProposedCarrier(ProposedCarrierDTO proposedCarrier) {

        int updatedRecord = proposedCarrierRepository.updateFromProposedCarrier(proposedCarrier.getProposedCarrierId(),
                proposedCarrier.getActualRemarksTx(),
                proposedCarrier.getApprovedRemarksTx(),
                proposedCarrier.getExchangeRateCy(),
                proposedCarrier.getForeignCodeIf(),
                proposedCarrier.getLicenseNumberIf(),
                proposedCarrier.getManufCtryCodeIf(),
                proposedCarrier.getProjectNumberIf(),
                proposedCarrier.getProposedRemarksBy(),
                proposedCarrier.getQuantityActual(),
                proposedCarrier.getQuantityApproved(),
                proposedCarrier.getQuantityNr(),
                proposedCarrier.getRemarks(),
                proposedCarrier.getRemarksActualBy(),
                proposedCarrier.getRemarksApprovedBy(),
                proposedCarrier.getRemarksProposedBy(),
                proposedCarrier.getRequestNumberIf(),
                proposedCarrier.getSerialNumberId(),
                proposedCarrier.getUnitPriceCy(),
                proposedCarrier.getUserName(),
                proposedCarrier.getVehCodeIf(),
                proposedCarrier.getVehType(),
                proposedCarrier.getVehicalName(),
                new Date());
        return updatedRecord;
    }
}
