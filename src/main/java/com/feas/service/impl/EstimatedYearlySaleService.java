package com.feas.service.impl;

import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.EstimatedYearlySales;
import com.feas.domain.entity.ProjectRevenue;
import com.feas.domain.entity.ProjectRevenuePK;
import com.feas.domain.entity.dto.EstimatedYearlySaleDTO;
import com.feas.domain.entity.dto.EstimatedYearlySaleSummary;
import com.feas.persistence.repository.EstimatedYearlySaleRepository;
import com.feas.persistence.repository.ProjectRevenueRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ١٦/٠٢/٢٠٢٣
 */
@Service
public class EstimatedYearlySaleService {

    private final EstimatedYearlySaleRepository estimatedYearlySaleRepository;
    private final ProjectRevenueRepository projectRevenueRepository;
    private final EconomicalStudySummaryService economicalStudySummaryService;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;

    public EstimatedYearlySaleService(EstimatedYearlySaleRepository estimatedYearlySaleRepository, ProjectRevenueRepository projectRevenueRepository, EconomicalStudySummaryService economicalStudySummaryService, ServiceObjectMapperImpl modelMapper) {
        this.estimatedYearlySaleRepository = estimatedYearlySaleRepository;
        this.projectRevenueRepository = projectRevenueRepository;
        this.economicalStudySummaryService = economicalStudySummaryService;
        this.modelMapper = modelMapper;
    }

    public List<EstimatedYearlySales> getAllFinishedGoodsStorageByRequestNumber(BigDecimal requestNumberId ){
        List<EstimatedYearlySales> allEstimatedYearlySaleByRequestNumber = estimatedYearlySaleRepository.getAllEstimatedYearlySaleByRequestNumber(requestNumberId);
        allEstimatedYearlySaleByRequestNumber.forEach(est->{
            est.setTotalPrice(est.getUnitPriceCy().multiply(est.getQuantityNr()));
        });
        return allEstimatedYearlySaleByRequestNumber;
    }

    public EstimatedYearlySaleSummary getEstimatedYearlySaleSummary(BigDecimal requestNumberId ){
        List<EstimatedYearlySales> allEstimatedYearlySaleByRequestNumber = getAllFinishedGoodsStorageByRequestNumber(requestNumberId);
        EstimatedYearlySaleSummary estimatedYearlySaleSummary=new EstimatedYearlySaleSummary();
        BigDecimal sumTotalPrice=BigDecimal.ZERO;
        BigDecimal sumTotalUnitePrice=BigDecimal.ZERO;
        BigDecimal sumTotalQuantityPrice=BigDecimal.ZERO;
        for(EstimatedYearlySales obj:allEstimatedYearlySaleByRequestNumber){
            sumTotalPrice=sumTotalPrice.add(obj.getTotalPrice());
            sumTotalUnitePrice=sumTotalUnitePrice.add(obj.getUnitPriceCy());
            sumTotalQuantityPrice=sumTotalQuantityPrice.add(obj.getQuantityNr());
          }
        estimatedYearlySaleSummary.setSumTotalPrice(sumTotalPrice);
        estimatedYearlySaleSummary.setSumTotalUnitePrice(sumTotalUnitePrice);
        estimatedYearlySaleSummary.setSumTotalQuantity(sumTotalQuantityPrice);
        return estimatedYearlySaleSummary;
    }

    public Page<EstimatedYearlySales> getAllFinishedGoodsStorageByRequestNumberPage(BigDecimal requestNumberId, Pageable page){
        return estimatedYearlySaleRepository.getAllEstimatedYearlySaleByRequestNumberPage(requestNumberId,page);
    }

    public String deleteEstimatedYearlySale(Long estimatedYearlySalesIdId) {
        return estimatedYearlySaleRepository.findById(estimatedYearlySalesIdId)
                .map(estimatedYearlySale -> {
                    estimatedYearlySale.setOperation("D");
                    EstimatedYearlySales save = estimatedYearlySaleRepository.save(estimatedYearlySale);

                    return  "Record have been successfully deleted!";
                }).orElseGet(() -> {
                    return null;
                });

    }

    public EstimatedYearlySales updateEstimatedYearlySale(EstimatedYearlySaleDTO estimatedYearlySaleDTO) {
        return estimatedYearlySaleRepository.findById(estimatedYearlySaleDTO.getEstimatedYearlySalesId())
                .map(estimatedYearlySale -> {
                    EstimatedYearlySales map = modelMapper.map(estimatedYearlySaleDTO, EstimatedYearlySales.class);
                    map.setEstimatedYearlySalesId(estimatedYearlySaleDTO.getEstimatedYearlySalesId());
                   // map.setOperation("U");
                    EstimatedYearlySales save = estimatedYearlySaleRepository.save(map);
                    if(save!=null){
                        ProjectRevenuePK projectRevenuePK=new ProjectRevenuePK();
                        projectRevenuePK.setProjectNumberIf(save.getProjectNumberIf());
                        projectRevenuePK.setLicenseNumberIf(save.getLicenseNumberIf());
                        projectRevenuePK.setRequestNumberIf(save.getRequestNumberIf().longValue());
                        Optional<ProjectRevenue> byId = projectRevenueRepository.findById(projectRevenuePK);
                        if(byId.isPresent()){
                           //EstimatedYearlySaleSummary estimatedYearlySaleSummary = getEstimatedYearlySaleSummary(save.getRequestNumberIf());
                            byId.get().setYrlySalesValCy(estimatedYearlySaleDTO.getSumTotalPrice());
                            projectRevenueRepository.save(byId.get());
                        }
                    }
                    return map;// "Customer details have been successfully updated!";
                }).orElseGet(() -> {
                    return null;
                });
    }

    public EstimatedYearlySales addEstimatedYearlySale(EstimatedYearlySaleDTO estimatedYearlySaleDTO) {
        EstimatedYearlySales map = modelMapper.map(estimatedYearlySaleDTO, EstimatedYearlySales.class);
        if(map!=null){
            ProjectRevenuePK projectRevenuePK=new ProjectRevenuePK();
            projectRevenuePK.setProjectNumberIf(map.getProjectNumberIf());
            projectRevenuePK.setLicenseNumberIf(map.getLicenseNumberIf());
            projectRevenuePK.setRequestNumberIf(map.getRequestNumberIf().longValue());
            Optional<ProjectRevenue> byId = projectRevenueRepository.findById(projectRevenuePK);
            if(byId.isPresent()){
                //EstimatedYearlySaleSummary estimatedYearlySaleSummary = getEstimatedYearlySaleSummary(map.getRequestNumberIf());
                byId.get().setYrlySalesValCy(estimatedYearlySaleDTO.getSumTotalPrice());
                projectRevenueRepository.save(byId.get());
            }
        }
        return estimatedYearlySaleRepository.save(map);
    }

    public int updateSummary(EstimatedYearlySaleSummary estimatedYearlySaleSummary,BigDecimal requestNumberIf){
        int returnRecord=0;
        if(estimatedYearlySaleSummary!=null){
             returnRecord = projectRevenueRepository.updateYrlySalesValCyFromEstimatedYearlySales(requestNumberIf.longValue(), estimatedYearlySaleSummary.getSumTotalPrice());
        }
        return returnRecord;
    }
}
