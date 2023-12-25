package com.feas.api.controller;

import com.feas.domain.entity.FinishedGoodsStorage;
import com.feas.domain.entity.IndustrialPlotBuildCost;
import com.feas.domain.entity.dto.CalculateIndustrialCost;
import com.feas.domain.entity.dto.FinishedGoodsStorageDTO;
import com.feas.domain.entity.dto.IndustrialPlotBuildCostDTO;
import com.feas.domain.entity.dto.TempRequestDTO;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.service.impl.ProductionLineAreaService;
import com.feas.service.impl.IndustrialPlotBuildCostService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٠٧/٠٢/٢٠٢٣
 */
@RestController
@RequestMapping("/industrial-plot-build-cost")
@Tag(name = "industrial-plot-build-cost", description = "N_INDUSTRIAL_PLOT_BUILD_COST -  مساحة القسيمة الصناعية وتكاليف المباني")
public class IndustrialPlotBuildCostController {

    private final IndustrialPlotBuildCostService  industrialPlotBuildCostService;
    private final ProductionLineAreaService productionLineAreaService;


    public IndustrialPlotBuildCostController(IndustrialPlotBuildCostService industrialPlotBuildCostService, ProductionLineAreaService productionLineAreaService) {
        this.industrialPlotBuildCostService = industrialPlotBuildCostService;
        this.productionLineAreaService = productionLineAreaService;
    }

    @GetMapping
    public BaseResponse<List<IndustrialPlotBuildCost>> getAllIndustrialPlotBuildCostByRequestNumber(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        List<IndustrialPlotBuildCost> allIndustrialPlotBuildCostByRequestNumber = industrialPlotBuildCostService.getAllIndustrialPlotBuildCostByRequestNumber(requestNumberIf);
        return new BaseResponse<>(allIndustrialPlotBuildCostByRequestNumber, HttpStatus.OK.toString());
    }
    @GetMapping("/summary-fields")
    @ResponseBody
    public BaseResponse<CalculateIndustrialCost> getSummaryIndustrialPlotBuildCostByRequestNumber(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        CalculateIndustrialCost calculateIndustrialCost = industrialPlotBuildCostService.getCalculateIndustrialCost(requestNumberIf);
        return new BaseResponse<>(calculateIndustrialCost, HttpStatus.OK.toString());
    }
    @PostMapping
    @ResponseBody
    public BaseResponse addFinishedGoodsStorage(@RequestBody IndustrialPlotBuildCostDTO industrialPlotBuildCost)throws URISyntaxException {
        IndustrialPlotBuildCost industrialPlotBuildCost1 = industrialPlotBuildCostService.save(industrialPlotBuildCost);
        if(industrialPlotBuildCost1!=null){
            return new BaseResponse(industrialPlotBuildCost1,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

    @PutMapping
    @ResponseBody
    public BaseResponse updateIndustrialPlotBuildCost(@RequestBody IndustrialPlotBuildCostDTO industrialPlotBuildCost)throws URISyntaxException {
        IndustrialPlotBuildCost industrialPlotBuildCost1 = industrialPlotBuildCostService.save(industrialPlotBuildCost);
        if(industrialPlotBuildCost1!=null){
            return new BaseResponse(industrialPlotBuildCost1,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
    @PutMapping("/summary-fields")
    @ResponseBody
    public BaseResponse updateIndustrialPlotBuildCostSummary(@RequestBody TempRequestDTO tempRequestDTO)throws URISyntaxException {
        TempRequest tempRequest = industrialPlotBuildCostService.updateSummaryFields(tempRequestDTO);
        if(tempRequest!=null){
            return new BaseResponse(tempRequest,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
}
