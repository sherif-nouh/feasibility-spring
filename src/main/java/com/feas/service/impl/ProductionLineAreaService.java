package com.feas.service.impl;

import com.feas.domain.entity.ProductionLineArea;
import com.feas.domain.entity.dto.TempRequestDTO;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.persistence.repository.ProductionLineAreaRepository;
import com.feas.persistence.repository.TempRequestRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٠٧/٠٢/٢٠٢٣
 */

@Service
public class ProductionLineAreaService {

    private final ProductionLineAreaRepository productionLineAreaRepository;
    private final TempRequestRepository tempRequestRepository;
    private final TempRequestService tempRequestService;

    public ProductionLineAreaService(ProductionLineAreaRepository productionLineAreaRepository, TempRequestRepository tempRequestRepository, TempRequestService tempRequestService) {
        this.productionLineAreaRepository = productionLineAreaRepository;
        this.tempRequestRepository = tempRequestRepository;
        this.tempRequestService = tempRequestService;
    }

    public List<ProductionLineArea> getAllProductionLineAreaByRequestNumber(BigDecimal requestNumberId,BigDecimal licenseNumberIf){
        List<ProductionLineArea> allProductionLineAreaByRequestNumber = productionLineAreaRepository.getAllProductionLineAreaByRequestNumber(requestNumberId,licenseNumberIf);


        BigDecimal sumTotalProductionLine=new BigDecimal(0);
        BigDecimal sumVSummary=new BigDecimal(0);
        for(ProductionLineArea obj:allProductionLineAreaByRequestNumber){
            sumTotalProductionLine=sumTotalProductionLine.add(obj.getTotal());
            sumVSummary=sumVSummary.add(obj.getVSummery());

        }
        for(ProductionLineArea obj:allProductionLineAreaByRequestNumber){
            obj.setSumTotalProductionLine(sumTotalProductionLine);
            obj.setSumVSummery(sumVSummary);

        }

        allProductionLineAreaByRequestNumber.forEach(prod ->{
            BigDecimal machLength;
            BigDecimal machWidth;
            if(prod.getMachDimensionLengthNr() == null){
                machLength = new BigDecimal(0);
            }else{
                machLength = prod.getMachDimensionLengthNr().setScale(2, BigDecimal.ROUND_UP);
            }
            if(prod.getMachDimensionWidthNr() == null){
                machWidth = new BigDecimal(0);
            }else{
                machWidth = prod.getMachDimensionWidthNr().setScale(2, BigDecimal.ROUND_UP);
            }
            BigDecimal sum = machLength.multiply (machWidth);
            prod.setAreaReqForMachNr(new BigDecimal(sum.longValue()));

            // getTotalAdditionArea
            BigDecimal totalAdditionalArea = getTotalAdditionalArea(prod);
            prod.setTotalAdditionalArea(totalAdditionalArea);



        });


       /* productionLineAreaWithSummeryFields.setProductionLineAreas(allProductionLineAreaByRequestNumber);
        productionLineAreaWithSummeryFields.setSumTotal(sumTotal);
        productionLineAreaWithSummeryFields.setSumVSummary(sumVSummary);*/
        allProductionLineAreaByRequestNumber.forEach(prod-> {
            // get sumTotal
            Optional<TempRequest> byRequestNumberIdAndLicenseNumberIf = tempRequestRepository.findByRequestNumberIdAndLicenseNumberIf(requestNumberId.longValue(), licenseNumberIf.longValue());
            Long additionalArea=0L;
            if(byRequestNumberIdAndLicenseNumberIf.isPresent()){
                additionalArea= byRequestNumberIdAndLicenseNumberIf.get().getAdditionalArea();
            }

            BigDecimal sum1=new BigDecimal(additionalArea).divide(new BigDecimal(100)).multiply( (prod.getSumTotalProductionLine()));
            BigDecimal sum11 = sum1.setScale(3, RoundingMode.HALF_UP);
            prod.setSumTotal(sum11.add(prod.getSumTotalProductionLine()));
        });
        return allProductionLineAreaByRequestNumber;
    }


    public Optional<ProductionLineArea> findById(Long id) {
        return productionLineAreaRepository.findById(id);
    }

    public ProductionLineArea save(ProductionLineArea productionLineArea) {
        return productionLineAreaRepository.save(productionLineArea);
    }

    /*public ProductionLineArea updateProposedManpower(ProductionLineArea productionLineArea) {
        return productionLineAreaRepository.findById(productionLineArea.getProductionLineAreaId())
                .map(proposedManpower -> {
                    //ProductionLineArea map = modelMapper.map(proposedManpowerDTO, ProposedManpower.class);
                    //productionLineArea.setPropose(proposedManpowerDTO.getProposedManpowerId());
                    //  map.setOperation("U");
                    productionLineAreaRepository.save(productionLineArea);
                    return productionLineArea;// "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return null;
                });
    }*/

    public BigDecimal getTotalAdditionalArea(ProductionLineArea productionLineArea) {
        Optional<TempRequest> byRequestNumberIdAndLicenseNumberIf = tempRequestRepository.findByRequestNumberIdAndLicenseNumberIf(productionLineArea.getRequestNumberIf().longValue(), productionLineArea.getLicenseNumberIf().longValue());
      if(byRequestNumberIdAndLicenseNumberIf.isPresent()) {
          if (byRequestNumberIdAndLicenseNumberIf.get().getAdditionalArea() != null) {
              return (productionLineArea.getSumTotalProductionLine()).multiply(new BigDecimal(byRequestNumberIdAndLicenseNumberIf.get().getAdditionalArea())).divide(new BigDecimal(100));
          } else {
              return (new BigDecimal(0));
          }

      }
        return (new BigDecimal(0));
    }

    public TempRequest updateSummaryFields(TempRequestDTO tempRequestDTO) {
        TempRequest tempRequest = tempRequestService.updateProposedManpower(tempRequestDTO);

        return tempRequest;
    }
}
