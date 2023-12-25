package com.feas.service.impl;

import com.feas.domain.config.CheckUtils;
import com.feas.domain.entity.ProposedStock;
import com.feas.domain.entity.dto.ProposedStockDTO;
import com.feas.domain.entity.dto.ProposedStockSummary;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.persistence.repository.ProposedStockRepository;
import com.feas.persistence.repository.TempRequestRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٠١/٠٢/٢٠٢٣
 */
@Service
public class ProposedStockService {
    private final ProposedStockRepository proposedStockRepository;
    private final TempRequestRepository tempRequestRepository;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;

    public ProposedStockService(ProposedStockRepository proposedStockRepository, TempRequestRepository tempRequestRepository, ServiceObjectMapperImpl modelMapper) {
        this.proposedStockRepository = proposedStockRepository;
        this.tempRequestRepository = tempRequestRepository;
        this.modelMapper = modelMapper;
    }


    public List<ProposedStock> getAllProposedStockByRequestNumber(BigDecimal requestNumberId){

        List<ProposedStock> allProposedStockByRequestNumber = proposedStockRepository.getAllProposedStockByRequestNumber(requestNumberId);
        return allProposedStockByRequestNumber;
    }

    public ProposedStockSummary getAllProposedStockSummaryByRequestNumber(BigDecimal requestNumberId){
        List<ProposedStock> allProposedStockByRequestNumber = proposedStockRepository.getAllProposedStockByRequestNumber(requestNumberId);
        ProposedStockSummary proposedStockSummary=new ProposedStockSummary();

        Optional<TempRequest> byRequestNumberId = tempRequestRepository.findByRequestNumberId(requestNumberId.longValue());
        if(byRequestNumberId.isPresent()){
            proposedStockSummary.setReqHandlerIf(new BigDecimal(byRequestNumberId.get().getReqHandlerIf()==null?0.0:byRequestNumberId.get().getReqHandlerIf()));
            proposedStockSummary.setRemarksByDept(byRequestNumberId.get().getRemarksBydept());
        }
        if(allProposedStockByRequestNumber!=null){
            BigDecimal prodOriginIf=new BigDecimal(1);
            BigDecimal stockType1=new BigDecimal(1);
            BigDecimal stockType2=new BigDecimal(2);
            proposedStockSummary.setRequestNumberIf(allProposedStockByRequestNumber.get(0).getRequestNumberIf().longValue());
            proposedStockSummary.setLicenseNumberIf(allProposedStockByRequestNumber.get(0).getLicenseNumberIf().longValue());
            BigDecimal locAvailMatSummary= allProposedStockByRequestNumber.stream().filter(prop->prop.getProdOriginIf().equals(new BigDecimal(1)))
                    .map(ProposedStock ::getTotalValue)    // map
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            proposedStockSummary.setLocAvailMatSummary(locAvailMatSummary);

            BigDecimal cif= allProposedStockByRequestNumber.stream()
                    .map(x -> x.getTotalValue())    // map
                    .reduce(BigDecimal.ZERO, BigDecimal::add).subtract(locAvailMatSummary);
            proposedStockSummary.setCifAvailMatSummary(cif);

            if(cif!=null){
                proposedStockSummary.setReqHandlerIf(CheckUtils.isNullOrZero(proposedStockSummary.getReqHandlerIf())?new BigDecimal(0):proposedStockSummary.getReqHandlerIf());
                BigDecimal result = proposedStockSummary.getReqHandlerIf().equals( new BigDecimal(0) )? new BigDecimal(0.02): proposedStockSummary.getReqHandlerIf().divide(new BigDecimal(100));
                proposedStockSummary.setTransportationExp(result.multiply(cif).setScale(3,RoundingMode.HALF_UP));
            }
            BigDecimal sumTotal= (proposedStockSummary.getCifAvailMatSummary()==null?new BigDecimal(0):proposedStockSummary.getCifAvailMatSummary())
                    .add((proposedStockSummary.getTransportationExp()==null?new BigDecimal(0):proposedStockSummary.getTransportationExp()))
                    .add(proposedStockSummary.getLocAvailMatSummary()==null?new BigDecimal(0):proposedStockSummary.getLocAvailMatSummary());
            proposedStockSummary.setSumTotal(sumTotal.setScale(3,RoundingMode.HALF_UP));

            BigDecimal rat=new BigDecimal(0);
            if(proposedStockSummary.getLocAvailMatSummary().compareTo(BigDecimal.ZERO)!=0){
                rat = proposedStockSummary.getLocAvailMatSummary().divide(proposedStockSummary.getSumTotal(),3,RoundingMode.HALF_UP).multiply(new BigDecimal(100));
            }
            proposedStockSummary.setRatioLocTotal(rat);

            BigDecimal sumStock= allProposedStockByRequestNumber.stream().filter(prop->prop.getStockType().compareTo(stockType1)==0)
                    .map(ProposedStock::getTotalValue)    // map
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            proposedStockSummary.setSumStock(sumStock);
            BigDecimal sumPacking= allProposedStockByRequestNumber.stream().filter(prop->prop.getStockType().compareTo(stockType2)==0)
                    .map(ProposedStock::getTotalValue)    // map
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            proposedStockSummary.setSumPacking(sumPacking);
        }

        return proposedStockSummary;
    }
    public Page<ProposedStock> getAllProposedStockByRequestNumberAsPage(BigDecimal requestNumberId, Pageable page){
        return proposedStockRepository.getAllProposedStockByRequestNumberAsPage(requestNumberId,page);
    }


    public String getRemarksBydept(BigDecimal requestNumberId){
        return proposedStockRepository.getRemarksBydept(requestNumberId);
    }

    public ProposedStock addProposedStock(ProposedStockDTO proposedManpowerDTO) {

        ProposedStock map = modelMapper.map(proposedManpowerDTO, ProposedStock.class);

        return proposedStockRepository.save(map);
    }

    public ProposedStock updateProposedStock(ProposedStockDTO proposedStockDTO) {
        return proposedStockRepository.findById(proposedStockDTO.getProposedStockId())
                .map(proposedStock -> {
                    ProposedStock map = modelMapper.map(proposedStockDTO, ProposedStock.class);
                    map.setProposedStockId(proposedStockDTO.getProposedStockId());
                  //  map.setOperation("U");
                    proposedStockRepository.save(map);
                    return map;// "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return null;
                });
    }
    public String deleteProposedStock(Long proposedManpowerId) {
        return proposedStockRepository.findById(proposedManpowerId)
                .map(proposedStock -> {
                    proposedStock.setOperation("D");
                    ProposedStock save = proposedStockRepository.save(proposedStock);
                    return  "Record have been successfully deleted!";
                }).orElseGet(() -> {
                    return null;
                });
    }
}



