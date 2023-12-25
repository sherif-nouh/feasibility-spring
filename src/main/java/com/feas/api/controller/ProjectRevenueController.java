package com.feas.api.controller;

import com.feas.domain.entity.EstimatedYearlySales;
import com.feas.domain.entity.ProjectRevenue;
import com.feas.domain.entity.ProposedStock;
import com.feas.domain.entity.dto.EstimatedYearlySaleDTO;
import com.feas.domain.entity.dto.ProjectRevenueCustom;
import com.feas.domain.entity.dto.ProjectRevenueCustomDTO;
import com.feas.domain.entity.dto.ProjectRevenueDTO;
import com.feas.service.impl.ProjectRevenueService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ١٣/٠٧/٢٠٢٣
 */
@RestController
@RequestMapping("/project-revenue")
@Tag(name = "project-revenue", description = "N_PROJECT_REVENUE -   المؤشرات الإقتصادية/عائدات المشروع")
@Component
public class ProjectRevenueController {

    private final ProjectRevenueService projectRevenueService;

    public ProjectRevenueController(ProjectRevenueService projectRevenueService) {
        this.projectRevenueService = projectRevenueService;
    }

    @GetMapping
    public BaseResponse<ProjectRevenueCustomDTO> getAllProposedStockByRequestNumber(
            @RequestParam(defaultValue = "-1") long requestNumberIf,
            @RequestParam(defaultValue = "-1") long licenseNumberIf){
        ProjectRevenueCustomDTO allManPowerByRequestNumber = projectRevenueService.getProjectRevenueCustom(requestNumberIf,licenseNumberIf);
        return new BaseResponse<>(allManPowerByRequestNumber, HttpStatus.OK.toString());
    }
    @PutMapping
    public long updateEstimatedYearlySale(@RequestBody ProjectRevenueDTO projectRevenueDTO) throws URISyntaxException {

        long estimatedYearlySale = projectRevenueService.update(projectRevenueDTO);
        return estimatedYearlySale;
    }
}
