package com.feas.service.impl;

import com.feas.domain.config.CheckUtils;
import com.feas.domain.entity.ProposedGeneralFacility;
import com.feas.domain.entity.ProposedManpower;
import com.feas.domain.entity.dto.ProposedGeneralFacilityDTO;
import com.feas.domain.entity.dto.ProposedManpowerDTO;
import com.feas.domain.entity.dto.SumGeneralFacility;
import com.feas.persistence.repository.ProposedGeneralFacilityRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٢/٢٠٢٣
 */
@Service
public class ProposedGeneralFacilityService {
    private final ProposedGeneralFacilityRepository proposedGeneralFacilityRepository;

    @Autowired
    private final ServiceObjectMapperImpl modelMapper;


    public ProposedGeneralFacilityService(ProposedGeneralFacilityRepository proposedGeneralFacilityRepository, ServiceObjectMapperImpl modelMapper) {
        this.proposedGeneralFacilityRepository = proposedGeneralFacilityRepository;
        this.modelMapper = modelMapper;
    }


    public List<ProposedGeneralFacility> getAllProposedGeneralFacilityByRequestNumber(BigDecimal requestNumberId){
        List<ProposedGeneralFacility> allProposedGeneralFacilityByRequestNumber = proposedGeneralFacilityRepository.getAllProposedGeneralFacilityByRequestNumber(requestNumberId);
        allProposedGeneralFacilityByRequestNumber.forEach( obj->{
            obj.setTotalValue((CheckUtils.isNullOrZero( obj.getQuantityNr())?new BigDecimal(0):obj.getQuantityNr()).multiply(CheckUtils.isNullOrZero( obj.getUnitCostCy())?new BigDecimal(0):obj.getUnitCostCy()).divide(new BigDecimal(1000)));
        });
      return allProposedGeneralFacilityByRequestNumber;
    }

    public Page<ProposedGeneralFacility> getAllProposedGeneralFacilityByRequestNumberAsPage(BigDecimal requestNumberId, Pageable page){
        return proposedGeneralFacilityRepository.getAllProposedGeneralFacilityByRequestNumberAsPage(requestNumberId,page);
    }

    public SumGeneralFacility getSumGeneralFacility (BigDecimal requestNumberId){
        return proposedGeneralFacilityRepository.getSumGeneralFacility(requestNumberId);
    }

    public ProposedGeneralFacility addProposedGeneralFacility(ProposedGeneralFacilityDTO proposedGeneralFacilityDTO) {

        ProposedGeneralFacility map = modelMapper.map(proposedGeneralFacilityDTO, ProposedGeneralFacility.class);
        map.setDateStamp(new Date());
        map.setGeneralFacility(null);
        return proposedGeneralFacilityRepository.save(map);
    }

    public ProposedGeneralFacility updateProposedGeneralFacility(ProposedGeneralFacilityDTO proposedGeneralFacilityDTO) {


        return proposedGeneralFacilityRepository.findById(proposedGeneralFacilityDTO.getProposedGeneralFacilityId())
                .map(proposedGeneralFacility -> {
                    ProposedGeneralFacility map = modelMapper.map(proposedGeneralFacilityDTO, ProposedGeneralFacility.class);
                    map.setDateStamp(new Date());
                    if(map!=null && "D".equalsIgnoreCase(map.getOperation()) ){
                        map.setOperation("D");
                    }else{
                        map.setOperation("U");
                    }
                    map.setProposedGeneralFacilityId(proposedGeneralFacilityDTO.getProposedGeneralFacilityId());
                   // map.setOperation("U");
                    map.setGeneralFacility(null);
                    proposedGeneralFacilityRepository.save(map);
                    return map;// "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return null;
                });
    }
    public String deleteProposedGeneralFacility(Long proposedManpowerId) {
        return proposedGeneralFacilityRepository.findById(proposedManpowerId)
                .map(proposedGeneralFacility -> {
                    proposedGeneralFacility.setOperation("D");
                    proposedGeneralFacility.setGeneralFacility(null);
                    ProposedGeneralFacility save = proposedGeneralFacilityRepository.save(proposedGeneralFacility);
                    return  "Record have been successfully deleted!";
                }).orElseGet(() -> {
                    return null;
                });
    }
}
