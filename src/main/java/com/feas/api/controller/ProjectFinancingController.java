package com.feas.api.controller;

import com.feas.domain.entity.FinishedGoodsStorage;
import com.feas.domain.entity.ProjectFinancing;
import com.feas.domain.entity.dto.FinishedGoodsStorageDTO;
import com.feas.domain.entity.dto.ProjectFinancingDTO;
import com.feas.domain.entity.dto.ProjectFinancingResponseDTO;
import com.feas.service.impl.ProjectFinancingService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@RestController
@RequestMapping("/project-financing")
@Tag(name = "project-financing", description = "N_PROJECT_FINANCING -   تمويل المشروع")
@Component
public class ProjectFinancingController {

    @Autowired
    private final ProjectFinancingService projectFinancingService;

    public ProjectFinancingController(ProjectFinancingService projectFinancingService) {
        this.projectFinancingService = projectFinancingService;
    }

    @GetMapping
    public BaseResponse<ProjectFinancingResponseDTO> getProjectFinancingByRequestNumberAndLicense(
            @RequestParam(defaultValue = "-1") BigDecimal requestNumberIf,
            @RequestParam(defaultValue = "-1") BigDecimal licenseNumberIf){
        ProjectFinancingResponseDTO projectFinancings = projectFinancingService.fetchAllProjectFinancingByRequestNumberAndLicense(requestNumberIf,licenseNumberIf);

        return new BaseResponse<>(projectFinancings, HttpStatus.OK.toString());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public BaseResponse<ProjectFinancing> getOneById(@PathVariable Long id) throws Exception {
        Optional<ProjectFinancing> projectFinancing= projectFinancingService.findById(id);
        return new BaseResponse<>(projectFinancing.orElseThrow(() -> new Exception(" not found - " + id)),HttpStatus.OK.toString());
    }

    @PostMapping
    @ResponseBody
    public BaseResponse addProjectFinancing(@RequestBody ProjectFinancingDTO projectFinancingDTO)throws URISyntaxException {
        projectFinancingDTO.setDateStamp(new Date());
        if(projectFinancingDTO!=null && "D".equalsIgnoreCase(projectFinancingDTO.getOperation()) ){
            projectFinancingDTO.setOperation("D");
        }else{
            projectFinancingDTO.setOperation("U");
        }
        ProjectFinancing projectFinancing = projectFinancingService.save(projectFinancingDTO);
        if(projectFinancing!=null){
            return new BaseResponse(projectFinancing, HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }

    }

    @PutMapping
    public BaseResponse<ProjectFinancingResponseDTO> updateProjectFinancing(@RequestBody ProjectFinancingResponseDTO projectFinancingDTO) throws URISyntaxException {
        ProjectFinancingResponseDTO projectFinancing = projectFinancingService.updateProjectFinancing(projectFinancingDTO);
        if(projectFinancing!=null){
            return new BaseResponse(projectFinancing, HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

}
