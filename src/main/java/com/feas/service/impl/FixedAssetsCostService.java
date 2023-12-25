package com.feas.service.impl;

import com.feas.domain.entity.FixedAssetsCost;
import com.feas.domain.entity.FixedAssetsCostPK;
import com.feas.domain.entity.ProposedManpower;
import com.feas.domain.entity.dto.FixedAssetsCostDTO;
import com.feas.domain.entity.dto.FixedAssetsCostReadOnlyFields;
import com.feas.domain.entity.dto.FixedAssetsCostReadOnlyFieldsDTO;
import com.feas.persistence.repository.FixedAssetsCostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ١٢/٠٣/٢٠٢٣
 */
@Service
public class FixedAssetsCostService {

    private final FixedAssetsCostRepository fixedAssetsCostRepository;

    public FixedAssetsCostService(FixedAssetsCostRepository fixedAssetsCostRepository) {
        this.fixedAssetsCostRepository = fixedAssetsCostRepository;

    }


    public FixedAssetsCostReadOnlyFieldsDTO getFixedAssetsCostReadOnlyFields(Long requestNumber){


        FixedAssetsCostReadOnlyFields allFexedAssetCostReadOnlyFields = fixedAssetsCostRepository.getAllFexedAssetCostReadOnlyFields(requestNumber);
        BigDecimal totalCost=
                allFexedAssetCostReadOnlyFields.getCbuild().add(allFexedAssetCostReadOnlyFields.getEquipmentCost()==null?new BigDecimal(0):allFexedAssetCostReadOnlyFields.getEquipmentCost())
                .add(allFexedAssetCostReadOnlyFields.getCostOfAirCondCy()==null?new BigDecimal(0):allFexedAssetCostReadOnlyFields.getCostOfAirCondCy())
                .add(allFexedAssetCostReadOnlyFields.getCostOfFurnCy()==null?new BigDecimal(0):allFexedAssetCostReadOnlyFields.getCostOfFurnCy())
                .add(allFexedAssetCostReadOnlyFields.getCostofstoreprepcy()==null?new BigDecimal(0):allFexedAssetCostReadOnlyFields.getCostofstoreprepcy())
                .add(allFexedAssetCostReadOnlyFields.getTvale()==null?new BigDecimal(0):allFexedAssetCostReadOnlyFields.getTvale())
                .add(allFexedAssetCostReadOnlyFields.getTvali()==null?new BigDecimal(0):allFexedAssetCostReadOnlyFields.getTvali());

        FixedAssetsCostReadOnlyFieldsDTO fixedAssetsCostReadOnlyFieldsDTO=new FixedAssetsCostReadOnlyFieldsDTO();
        fixedAssetsCostReadOnlyFieldsDTO.setCostOfFurnCy(allFexedAssetCostReadOnlyFields.getCostOfFurnCy());
        fixedAssetsCostReadOnlyFieldsDTO.setCostOfSpartsCy(allFexedAssetCostReadOnlyFields.getCostOfSpartsCy());
        fixedAssetsCostReadOnlyFieldsDTO.setEquipmentCost(allFexedAssetCostReadOnlyFields.getEquipmentCost());
        fixedAssetsCostReadOnlyFieldsDTO.setCostOfEquipCy(allFexedAssetCostReadOnlyFields.getCostOfEquipCy());
        fixedAssetsCostReadOnlyFieldsDTO.setCostOfAirCondCy(allFexedAssetCostReadOnlyFields.getCostOfAirCondCy());
        fixedAssetsCostReadOnlyFieldsDTO.setOtherCostCy(allFexedAssetCostReadOnlyFields.getOtherCostCy());
        fixedAssetsCostReadOnlyFieldsDTO.setCostofstoreprepcy(allFexedAssetCostReadOnlyFields.getCostofstoreprepcy());
        fixedAssetsCostReadOnlyFieldsDTO.setTotalCost(totalCost);
        fixedAssetsCostReadOnlyFieldsDTO.setFixedAssetsTotalCost(allFexedAssetCostReadOnlyFields.getFixedAssetsTotalCost());
        fixedAssetsCostReadOnlyFieldsDTO.setCbuild(allFexedAssetCostReadOnlyFields.getCbuild());
        fixedAssetsCostReadOnlyFieldsDTO.setCostOfExtTranspVehCy(allFexedAssetCostReadOnlyFields.getCostOfExtTranspVehCy());
        fixedAssetsCostReadOnlyFieldsDTO.setCostOfIntTranspVehCy(allFexedAssetCostReadOnlyFields.getCostOfIntTranspVehCy());
        fixedAssetsCostReadOnlyFieldsDTO.setTvale(allFexedAssetCostReadOnlyFields.getTvale());
        fixedAssetsCostReadOnlyFieldsDTO.setTvali(allFexedAssetCostReadOnlyFields.getTvali());
        fixedAssetsCostReadOnlyFieldsDTO.setRequestNumberIf(allFexedAssetCostReadOnlyFields.getRequestNumberIf());
        fixedAssetsCostReadOnlyFieldsDTO.setLicenseNumberIf(allFexedAssetCostReadOnlyFields.getLicenseNumberIf());
        fixedAssetsCostReadOnlyFieldsDTO.setProjectNumberIf(allFexedAssetCostReadOnlyFields.getProjectNumberIf());
        fixedAssetsCostReadOnlyFieldsDTO.setCostOfBuildConstCy(allFexedAssetCostReadOnlyFields.getCostOfBuildConstCy());
        fixedAssetsCostReadOnlyFieldsDTO.setUserName(allFexedAssetCostReadOnlyFields.getUserName());
        return fixedAssetsCostReadOnlyFieldsDTO;
    }

    public FixedAssetsCost findById(FixedAssetsCostReadOnlyFieldsDTO fixedAssetsCostReadOnlyFields) {
        FixedAssetsCostPK fixedAssetsCostPK=new FixedAssetsCostPK();
        FixedAssetsCost save=null;
        if(fixedAssetsCostReadOnlyFields!=null) {
            if(fixedAssetsCostReadOnlyFields.getRequestNumberIf()!=0)
                fixedAssetsCostPK.setLicenseNumberIf(fixedAssetsCostReadOnlyFields.getLicenseNumberIf());
            fixedAssetsCostPK.setRequestNumberIf(fixedAssetsCostReadOnlyFields.getRequestNumberIf());
            fixedAssetsCostPK.setProjectNumberIf(fixedAssetsCostReadOnlyFields.getLicenseNumberIf());

            Optional<FixedAssetsCost> byId = fixedAssetsCostRepository.findById(fixedAssetsCostPK);
            if(byId.isPresent()){
                byId.get().setCostOfExtTranspVehCy(fixedAssetsCostReadOnlyFields.getTvale());
                byId.get().setCostOfIntTranspVehCy(fixedAssetsCostReadOnlyFields.getTvali());
                byId.get().setCostOfEquipCy(fixedAssetsCostReadOnlyFields.getEquipmentCost());
                byId.get().setCostOfBuildConstCy(fixedAssetsCostReadOnlyFields.getCbuild());
                byId.get().setOperation("U");
                byId.get().setDateStamp(new Date());
                save = fixedAssetsCostRepository.save(byId.get());
            }

        }

        return save;
    }

    public FixedAssetsCostReadOnlyFieldsDTO save(FixedAssetsCostReadOnlyFieldsDTO fixedAssetsCostReadOnlyFields) {
        FixedAssetsCostPK fixedAssetsCostPK=new FixedAssetsCostPK();
        fixedAssetsCostPK.setProjectNumberIf(fixedAssetsCostReadOnlyFields.getLicenseNumberIf());
        fixedAssetsCostPK.setLicenseNumberIf(fixedAssetsCostReadOnlyFields.getLicenseNumberIf());
        fixedAssetsCostPK.setRequestNumberIf(fixedAssetsCostReadOnlyFields.getRequestNumberIf());

        Optional<FixedAssetsCost> byId = fixedAssetsCostRepository.findById(fixedAssetsCostPK);
        if(byId.isPresent()){
            FixedAssetsCost fixedAssetsCost = byId.get();
            fixedAssetsCost.setDateStamp(new Date());
            fixedAssetsCost.setCostOfBuildConstCy(fixedAssetsCostReadOnlyFields.getCbuild());
            fixedAssetsCost.setCostOfIntTranspVehCy(fixedAssetsCostReadOnlyFields.getTvali());
            fixedAssetsCost.setCostOfExtTranspVehCy(fixedAssetsCostReadOnlyFields.getTvale());
            fixedAssetsCost.setCostOfEquipCy(fixedAssetsCostReadOnlyFields.getEquipmentCost());
            fixedAssetsCost.setCostOfAirCondCy(fixedAssetsCostReadOnlyFields.getCostOfAirCondCy());
            fixedAssetsCost.setCostOfFurnCy(fixedAssetsCostReadOnlyFields.getCostOfFurnCy());
            fixedAssetsCost.setCostOfStorePrepCy(fixedAssetsCostReadOnlyFields.getCostofstoreprepcy());
            fixedAssetsCost.setCostOfSpartsCy(fixedAssetsCostReadOnlyFields.getCostOfSpartsCy());
            fixedAssetsCost.setUserName(fixedAssetsCostReadOnlyFields.getUserName());
            FixedAssetsCost save = fixedAssetsCostRepository.save(fixedAssetsCost);
      if(save!=null){
          return fixedAssetsCostReadOnlyFields;
          }
           }
        return null;

    }
}
