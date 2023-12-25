package com.feas.service.impl;

import com.feas.domain.entity.ProposedGeneralFacility;
import com.feas.domain.entity.RawMaterialStorage;
import com.feas.domain.entity.dto.*;
import com.feas.persistence.repository.RawMaterialStorageRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import com.feas.service.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٠٥/٠٢/٢٠٢٣
 */
@Service
public class RawMaterialStorageService {
    private final RawMaterialStorageRepository rawMaterialStorageRepository;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;

    public RawMaterialStorageService(RawMaterialStorageRepository rawMaterialStorageRepository, ServiceObjectMapperImpl modelMapper) {
        this.rawMaterialStorageRepository = rawMaterialStorageRepository;
        this.modelMapper = modelMapper;
    }


    //get all by request as list
    public List<RawMaterialStorage> getAllRawMaterialByRequestNumber(BigDecimal requestNumberId){
        return rawMaterialStorageRepository.getAllRawMaterialByRequestNumber(requestNumberId);
    }
    //get all by request as page
    public Page<RawMaterialStorage> getAllRawMaterialStorageByRequestNumberAsPage(BigDecimal requestNumberId, Pageable page){
        return rawMaterialStorageRepository.getAllRawMaterialStorageByRequestNumberAsPage(requestNumberId,page);
    }

    //custom fields

    public SumRawMaterialDTO getSumRawMaterial(BigDecimal requestNumberIf){
        SumRawMaterialDTO sumRawMaterial = rawMaterialStorageRepository.getSumRawMaterial(requestNumberIf);
        return sumRawMaterial;
    }
    //add new raw mat
    public RawMaterialStorage addRawMaterialStorage(RawMaterialStorageDTO rawMaterialStorageDTO) {
        RawMaterialStorage map = modelMapper.map(rawMaterialStorageDTO, RawMaterialStorage.class);
        //map.setDateStamp(new Date());
        return rawMaterialStorageRepository.save(map);
    }
    //edit row mat
    public RawMaterialStorage updateRawMaterialStorage(RawMaterialStorageDTO rawMaterialStorageDTO) {
        return rawMaterialStorageRepository.findById(rawMaterialStorageDTO.getRawMaterialStorageId())
                .map(rawMaterialStorage -> {
                    RawMaterialStorage map = modelMapper.map(rawMaterialStorageDTO, RawMaterialStorage.class);
                    map.setRawMaterialStorageId(rawMaterialStorageDTO.getRawMaterialStorageId());
                   // map.setOperation("U");
                    rawMaterialStorageRepository.save(map);
                    return map;// "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return null;
                });
    }
    public String deleteRawMaterialStorage(Long proposedManpowerId) {
        return rawMaterialStorageRepository.findById(proposedManpowerId)
                .map(rawMaterialStorage -> {
                    rawMaterialStorage.setOperation("D");
                    RawMaterialStorage save = rawMaterialStorageRepository.save(rawMaterialStorage);
                    return  "Record have been successfully deleted!";
                }).orElseGet(() -> {
                    return null;
                });
    }

}
