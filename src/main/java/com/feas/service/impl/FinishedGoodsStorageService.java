package com.feas.service.impl;

import com.feas.domain.entity.FinishedGoodsStorage;
import com.feas.domain.entity.dto.FinishedGoodsStorageDTO;
import com.feas.domain.entity.dto.FinishedGoodsStorageSummaryFields;
import com.feas.domain.entity.dto.TempRequestDTO;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.persistence.repository.FinishedGoodsStorageRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٠٨/٠٢/٢٠٢٣
 */
@Service
public class FinishedGoodsStorageService {
    private final FinishedGoodsStorageRepository finishedGoodsStorageRepository;
    private final TempRequestService tempRequestService;

    @Autowired
    private final ServiceObjectMapperImpl modelMapper;

    public FinishedGoodsStorageService(FinishedGoodsStorageRepository finishedGoodsStorageRepository, TempRequestService tempRequestService, ServiceObjectMapperImpl modelMapper) {
        this.finishedGoodsStorageRepository = finishedGoodsStorageRepository;
        this.tempRequestService = tempRequestService;
        this.modelMapper = modelMapper;
    }


    public List<FinishedGoodsStorage> getAllFinishedGoodsStorageByRequestNumber(BigDecimal requestNumberId ){
        return finishedGoodsStorageRepository.getAllFinishedGoodsStorageByRequestNumber(requestNumberId);
    }
    public FinishedGoodsStorageSummaryFields getAllSummeryFields(BigDecimal requestNumberId){
        BigDecimal allTotal = finishedGoodsStorageRepository.getAllTotal(requestNumberId);
        BigDecimal totalCal = finishedGoodsStorageRepository.getTotalCal(requestNumberId);
        BigDecimal grandTotal = finishedGoodsStorageRepository.getGrandTotal(requestNumberId);
        FinishedGoodsStorageSummaryFields finishedGoodsStorageSummaryFields =new FinishedGoodsStorageSummaryFields();
        finishedGoodsStorageSummaryFields.setAllTotal(allTotal);
        finishedGoodsStorageSummaryFields.setGrandTotal(grandTotal);
        finishedGoodsStorageSummaryFields.setTotalCal(totalCal);
        finishedGoodsStorageSummaryFields.setRequestNumberId(requestNumberId);
        return finishedGoodsStorageSummaryFields;
    }

    public Optional<FinishedGoodsStorage> findById(Long id) {
        return finishedGoodsStorageRepository.findById(id);
    }

    public FinishedGoodsStorage save(FinishedGoodsStorageDTO finishedGoodsStorageDTO) {
        FinishedGoodsStorage map = modelMapper.map(finishedGoodsStorageDTO, FinishedGoodsStorage.class);
        return finishedGoodsStorageRepository.save(map);
    }

    public FinishedGoodsStorage updateProposedManpower(FinishedGoodsStorageDTO finishedGoodsStorageDTO) {
        return finishedGoodsStorageRepository.findById(finishedGoodsStorageDTO.getFinishedGoodsStorageId())
                .map(finishedGoodsStorage -> {
                    FinishedGoodsStorage map = modelMapper.map(finishedGoodsStorageDTO, FinishedGoodsStorage.class);
                    map.setFinishedGoodsStorageId(finishedGoodsStorageDTO.getFinishedGoodsStorageId());
                    //map.setOperation("U");
                    finishedGoodsStorageRepository.save(map);
                    return map;// "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return null;
                });
    }
    public String deleteFinishedGoodsStorage(Long finishedGoodsStorageId) {
        return finishedGoodsStorageRepository.findById(finishedGoodsStorageId)
                .map(finishedGoodsStorage -> {
                    finishedGoodsStorage.setOperation("D");
                    FinishedGoodsStorage save = finishedGoodsStorageRepository.save(finishedGoodsStorage);
                    return  "Record have been successfully deleted!";
                }).orElseGet(() -> {
                    return null;
                });
    }

    public TempRequest updateSummaryFields(TempRequestDTO tempRequestDTO) {
        TempRequest tempRequest = tempRequestService.updateProposedManpower(tempRequestDTO);
        return tempRequest;
    }
}
