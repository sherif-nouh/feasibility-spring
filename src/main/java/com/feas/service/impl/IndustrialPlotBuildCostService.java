package com.feas.service.impl;

import com.feas.domain.entity.IndustrialPlotBuildCost;
import com.feas.domain.entity.dto.CalculateIndustrialCost;
import com.feas.domain.entity.dto.IndustrialPlotBuildCostDTO;
import com.feas.domain.entity.dto.TempRequestDTO;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.persistence.repository.IndustrialPlotBuildCostRepository;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٠٧/٠٢/٢٠٢٣
 */
@Service
public class IndustrialPlotBuildCostService {
    private final IndustrialPlotBuildCostRepository industrialPlotBuildCostRepository;
    private final TempRequestService tempRequestService;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;
    public IndustrialPlotBuildCostService(IndustrialPlotBuildCostRepository industrialPlotBuildCostRepository, TempRequestService tempRequestService, ServiceObjectMapperImpl modelMapper) {
        this.industrialPlotBuildCostRepository = industrialPlotBuildCostRepository;
        this.tempRequestService = tempRequestService;
        this.modelMapper = modelMapper;
    }

    public List<IndustrialPlotBuildCost> getAllIndustrialPlotBuildCostByRequestNumber(BigDecimal requestNumberId){
        return calculateSummaryFields(industrialPlotBuildCostRepository.getAllIndustrialPlotBuildCostByRequestNumber(requestNumberId));
    }

    public CalculateIndustrialCost getCalculateIndustrialCost(BigDecimal requestNumberId){
        CalculateIndustrialCost calculateIndustrialCost = industrialPlotBuildCostRepository.getCalculateIndustrialCost(requestNumberId);

        return calculateIndustrialCost;
    }

    private List<IndustrialPlotBuildCost> calculateSummaryFields(List<IndustrialPlotBuildCost> allIndustrialPlotBuildCostByRequestNumber){
        BigDecimal carea=new BigDecimal(0);
        BigDecimal barea=new BigDecimal(0);
        BigDecimal rawmat=new BigDecimal(0);
        for(IndustrialPlotBuildCost obj:allIndustrialPlotBuildCostByRequestNumber){
            if(obj.getBuildCodeIf().intValue()==1||obj.getBuildCodeIf().intValue()==23|| obj.getBuildCodeIf().intValue()==6){
                carea=carea.add(obj.getAreaNr());
                obj.setCArea(carea);
            }
            if(obj.getBuildCodeIf().intValue()==1||obj.getBuildCodeIf().intValue()==23|| obj.getBuildCodeIf().intValue()==6||obj.getBuildCodeIf().intValue()==24){
                barea=barea.add(obj.getAreaNr());
                obj.setBArea(barea);
            }

        }


      return allIndustrialPlotBuildCostByRequestNumber;
    }

    public IndustrialPlotBuildCost save(IndustrialPlotBuildCostDTO industrialPlotBuildCost) {
        IndustrialPlotBuildCost map = modelMapper.map(industrialPlotBuildCost, IndustrialPlotBuildCost.class);
        map.setDateStamp(new Date());
        map.setBuilding(null);
        return industrialPlotBuildCostRepository.save(map);
    }

    public TempRequest updateSummaryFields(TempRequestDTO tempRequestDTO) {
        TempRequest tempRequest = tempRequestService.updateProposedManpower(tempRequestDTO);
        if(tempRequest!=null) {
            industrialPlotBuildCostRepository.PLOT_BUILD_COST(new BigDecimal(tempRequestDTO.getRequestNumberId()));
        }
        return tempRequest;
    }
}
