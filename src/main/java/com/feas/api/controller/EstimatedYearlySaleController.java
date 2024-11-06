package com.feas.api.controller;

import com.feas.domain.entity.EstimatedYearlySales;
import com.feas.domain.entity.FinishedGoodsStorage;
import com.feas.domain.entity.ProposedGeneralFacility;
import com.feas.domain.entity.ProposedStock;
import com.feas.domain.entity.dto.EstimatedYearlySaleDTO;
import com.feas.domain.entity.dto.EstimatedYearlySaleSummary;
import com.feas.domain.entity.dto.ProposedStockDTO;
import com.feas.service.impl.EstimatedYearlySaleService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
 * @Date ١٦/٠٢/٢٠٢٣
 */
@RestController
@RequestMapping("/estimated-yearly-sale")
@Tag(name = "estimated-yearly-sale", description = "N_ESTIMATED_YEARLY_SALES -  تقديرات قيمة المبيعات السنوية")
public class EstimatedYearlySaleController {

    private final EstimatedYearlySaleService estimatedYearlySaleService;

    public EstimatedYearlySaleController(EstimatedYearlySaleService estimatedYearlySaleService) {
        this.estimatedYearlySaleService = estimatedYearlySaleService;
    }

    @GetMapping
    @ResponseBody
    public BaseResponse<List<EstimatedYearlySales>> getAllEstimatedYearlySaleByRequestNumber(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        List<EstimatedYearlySales> estimatedYearlySales = estimatedYearlySaleService.getAllFinishedGoodsStorageByRequestNumber(requestNumberIf);
        return new BaseResponse<>(estimatedYearlySales, HttpStatus.OK.toString());
    }
    @GetMapping("/summary")
    @ResponseBody
    public BaseResponse<EstimatedYearlySaleSummary> getYearlySaleSummaryBaseResponse(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        EstimatedYearlySaleSummary estimatedYearlySaleSummary = estimatedYearlySaleService.getEstimatedYearlySaleSummary(requestNumberIf);
        return new BaseResponse<>(estimatedYearlySaleSummary, HttpStatus.OK.toString());
    }

    @GetMapping("/page")
    public BaseResponse<Page<EstimatedYearlySales>> getAllEstimatedYearlySaleByRequestNumberAsPage(
            @RequestParam(defaultValue = "-1") BigDecimal requestNumberIf,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<EstimatedYearlySales> estimatedYearlySales = estimatedYearlySaleService.getAllFinishedGoodsStorageByRequestNumberPage(requestNumberIf,pageable);
        return new BaseResponse<>(estimatedYearlySales, HttpStatus.OK.toString());
    }

    @PostMapping
    @ResponseBody
    public BaseResponse<EstimatedYearlySales> addEstimatedYearlySale(@RequestBody EstimatedYearlySaleDTO estimatedYearlySaleDTO) throws URISyntaxException {
        estimatedYearlySaleDTO.setDateStamp(new Date());
        EstimatedYearlySales proposedStock = estimatedYearlySaleService.addEstimatedYearlySale(estimatedYearlySaleDTO);
        if(proposedStock!=null){
            return new BaseResponse(proposedStock,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }


    }


    @PutMapping
    @ResponseBody
    public BaseResponse<EstimatedYearlySales> updateEstimatedYearlySale(@RequestBody EstimatedYearlySaleDTO estimatedYearlySaleDTO) throws URISyntaxException {
        if(estimatedYearlySaleDTO!=null && "D".equalsIgnoreCase(estimatedYearlySaleDTO.getOperation()) ){
            estimatedYearlySaleDTO.setOperation("D");
        }else{
            estimatedYearlySaleDTO.setOperation("U");
        }
        estimatedYearlySaleDTO.setDateStamp(new Date());
        EstimatedYearlySales estimatedYearlySale = estimatedYearlySaleService.updateEstimatedYearlySale(estimatedYearlySaleDTO);
        if(estimatedYearlySale!=null){
            return new BaseResponse(estimatedYearlySale,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

    @PutMapping("/summary")
    @ResponseBody
    public BaseResponse<EstimatedYearlySaleSummary> updateSummary(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf ,
                                                                  @RequestBody EstimatedYearlySaleSummary estimatedYearlySaleDTO) throws URISyntaxException {
        int estimatedYearlySaleSummary = estimatedYearlySaleService.updateSummary(estimatedYearlySaleDTO,requestNumberIf);
        if(estimatedYearlySaleSummary!=0){
            return new BaseResponse(estimatedYearlySaleDTO,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

    @DeleteMapping("/{estimatedYearlySalesIdId}")
    public BaseResponse<String> deleteEstimatedYearlySale(@PathVariable Long estimatedYearlySalesIdId) throws URISyntaxException {
        String estimatedYearlySale = estimatedYearlySaleService.deleteEstimatedYearlySale(estimatedYearlySalesIdId);
        return new BaseResponse(estimatedYearlySale,HttpStatus.OK.toString());
    }


}
