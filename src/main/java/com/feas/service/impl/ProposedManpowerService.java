package com.feas.service.impl;

import com.feas.domain.entity.ProposedManpower;
import com.feas.domain.entity.dto.ProposedManpowerDTO;
import com.feas.domain.entity.dto.SummaryLabour;
import com.feas.persistence.repository.ProposedManpowerRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProposedManpowerService {

    private final ProposedManpowerRepository proposedManpowerRepository;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;

    public ProposedManpowerService(ProposedManpowerRepository proposedManpowerRepository, ServiceObjectMapperImpl modelMapper) {
        this.proposedManpowerRepository = proposedManpowerRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProposedManpower> getAllManPowerByRequestNumber(BigDecimal requestNumberId){
        return proposedManpowerRepository.getAllManPowerByRequestNumber(requestNumberId);
    }

    public Page<ProposedManpower> getAllManPowerByRequestNumberAsPage(BigDecimal requestNumberId, Pageable page){
        return proposedManpowerRepository.getAllManPowerByRequestNumberAsPage(requestNumberId,page);
    }

    public SummaryLabour getSummaryLabour(BigDecimal requestNumberId){
        return proposedManpowerRepository.getSummaryLabour(requestNumberId);
    }

    public String getDeptRemarks(BigDecimal requestNumberId){
     return proposedManpowerRepository.getDeptRemarks(requestNumberId);
    }

    public ProposedManpower addProposedManpower(ProposedManpowerDTO proposedManpowerDTO) {
        ProposedManpower map = modelMapper.map(proposedManpowerDTO, ProposedManpower.class);
        map.setDateStamp(new Date());
        map.setManpower(null);
        if (proposedManpowerDTO != null && proposedManpowerDTO.getProposedManpowerId() != 0l) {

            if (proposedManpowerDTO.getOperation() != null && proposedManpowerDTO.getOperation() == "D") {
                proposedManpowerDTO.setOperation("D");

            } else {
                proposedManpowerDTO.setOperation("U");

            }
            return proposedManpowerRepository.save(map);

        } else {

            map.setDateStamp(new Date());
            proposedManpowerDTO.setOperation("I");
            return proposedManpowerRepository.save(map);
        }

    }

    public ProposedManpower updateProposedManpower(ProposedManpowerDTO proposedManpowerDTO) {
        return proposedManpowerRepository.findById(proposedManpowerDTO.getProposedManpowerId())
                .map(proposedManpower -> {
                    ProposedManpower map = modelMapper.map(proposedManpowerDTO, ProposedManpower.class);
                    map.setProposedManpowerId(proposedManpowerDTO.getProposedManpowerId());
                  //  map.setOperation("U");
                    proposedManpowerRepository.save(map);
                    return map;// "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return null;
                });
    }
    public String deleteProposedManpower(Long proposedManpowerId) {
        return proposedManpowerRepository.findById(proposedManpowerId)
                .map(proposedManpower -> {
                    proposedManpower.setOperation("D");
                    ProposedManpower save = proposedManpowerRepository.save(proposedManpower);
                    return  "Record have been successfully deleted!";
                }).orElseGet(() -> {
                    return null;
                });
    }

}
