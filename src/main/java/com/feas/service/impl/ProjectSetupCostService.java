package com.feas.service.impl;

import com.feas.domain.entity.ProjectSetupCost;
import com.feas.persistence.repository.ProjectSetupCostRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@Service
public class ProjectSetupCostService {
    private final ProjectSetupCostRepository projectSetupCostRepository;

    public ProjectSetupCostService(ProjectSetupCostRepository projectSetupCostRepository) {
        this.projectSetupCostRepository = projectSetupCostRepository;
    }

    public ProjectSetupCost findProjectSetupCostByRequest(BigDecimal requestNumberIf){
        Optional<ProjectSetupCost> firstByRequestNumberIf = projectSetupCostRepository.findFirstByRequestNumberIf(requestNumberIf);
        if(firstByRequestNumberIf.isPresent()){
           BigDecimal totalCost= firstByRequestNumberIf.get().getCostOfStdTechDocCy()
                    .add(firstByRequestNumberIf.get().getCostOfTrlConslCy())
                    .add(firstByRequestNumberIf.get().getCostOfTrngCy())
                    .add(firstByRequestNumberIf.get().getCostOfMarktPromCy())
                    .add(firstByRequestNumberIf.get().getCostOfStrtProdPreOpCy())
                    .add(firstByRequestNumberIf.get().getOthersCostCy());
            firstByRequestNumberIf.get().setProjectSetupCost(totalCost);
            return firstByRequestNumberIf.get();
        }
        return null;
    }

    public ProjectSetupCost findById(ProjectSetupCost projectSetupCost) {
        if(projectSetupCost!=null) {
            Optional<ProjectSetupCost> byId = projectSetupCostRepository.findById(projectSetupCost.getProjectSetupCostId());
            if(byId.isPresent()){
                projectSetupCost.setDateStamp(new Date());
                projectSetupCost.setOperation("U");
                return projectSetupCostRepository.save(projectSetupCost);
            }
        }
        return null;
    }


}
