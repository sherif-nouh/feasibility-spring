package com.feas.api.controller;

import com.feas.domain.entity.ProjectSetupCost;
import com.feas.domain.entity.dto.FixedAssetsCostReadOnlyFields;
import com.feas.domain.entity.dto.FixedAssetsCostReadOnlyFieldsDTO;
import com.feas.service.impl.ProjectSetupCostService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@RestController
@Tag(name = "project-setup-cost", description = "N_PROJECT_SETUP_COST  - تقديرات مصاريف التأسيس ")
@RequestMapping("/project-setup-cost")
public class ProjectSetupCostController {

    private final ProjectSetupCostService projectSetupCostService;

    public ProjectSetupCostController(ProjectSetupCostService projectSetupCostService) {
        this.projectSetupCostService = projectSetupCostService;
    }

    @GetMapping
    @ResponseBody
    public BaseResponse<ProjectSetupCost> geProjectSetupCostByRequest(
            @RequestParam(defaultValue = "-1") BigDecimal requestNumberIf) {
        ProjectSetupCost projectSetupCost = projectSetupCostService.findProjectSetupCostByRequest(requestNumberIf);
        return new BaseResponse<>(projectSetupCost, HttpStatus.OK.toString());

    }

    @PutMapping
    public BaseResponse<ProjectSetupCost> updateFixedAssetCost(@RequestBody ProjectSetupCost projectSetupCost) {
        ProjectSetupCost byId = projectSetupCostService.findById(projectSetupCost);
        if(byId!=null){
            return new BaseResponse(byId,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
}
