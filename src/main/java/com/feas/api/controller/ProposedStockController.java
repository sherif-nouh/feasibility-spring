package com.feas.api.controller;

import com.feas.domain.entity.ProposedManpower;
import com.feas.domain.entity.ProposedProjectEquipment;
import com.feas.domain.entity.ProposedStock;
import com.feas.domain.entity.TechnicalStudySummary;
import com.feas.domain.entity.dto.ProposedManpowerDTO;
import com.feas.domain.entity.dto.ProposedStockDTO;
import com.feas.domain.entity.dto.ProposedStockSummary;
import com.feas.domain.entity.dto.SummaryLabour;
import com.feas.service.impl.ProposedStockService;
import com.feas.service.impl.TechnicalStudySummaryService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Date ٠١/٠٢/٢٠٢٣
 */
@RestController()
@RequestMapping("/proposed-stock")
@Tag(name = "proposed-stock", description = "N_PROPOSED_STOCK -   المواد الأولية اللازمة للإنتاج")
public class ProposedStockController {

    private final ProposedStockService  proposedStockService;
    @Autowired
    private TechnicalStudySummaryService technicalStudySummaryService;
    public ProposedStockController(ProposedStockService proposedStockService) {
        this.proposedStockService = proposedStockService;
    }

    @GetMapping
    public BaseResponse<List<ProposedStock>> getAllProposedStockByRequestNumber(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        List<ProposedStock> allManPowerByRequestNumber = proposedStockService.getAllProposedStockByRequestNumber(requestNumberIf);
        return new BaseResponse<>(allManPowerByRequestNumber, HttpStatus.OK.toString());
    }

    @GetMapping("/page")
    public BaseResponse<Page<ProposedStock>> getAllManPowerByRequestNumberAsPage(
            @RequestParam(defaultValue = "-1") BigDecimal requestNumberIf,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<ProposedStock> allProposedStockByRequestNumber = proposedStockService.getAllProposedStockByRequestNumberAsPage(requestNumberIf,pageable);
        return new BaseResponse<>(allProposedStockByRequestNumber, HttpStatus.OK.toString());
    }

    @GetMapping("/remarks-by-dept")
    public BaseResponse<String> getDeptRemarks(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        String deptRemarks = proposedStockService.getRemarksBydept(requestNumberIf);
        return new BaseResponse(deptRemarks,HttpStatus.OK.toString());
    }
    @GetMapping("/summary")
    public BaseResponse<ProposedStockSummary> getAllProposedStockSummaryByRequestNumber(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        ProposedStockSummary proposedStockSummary = proposedStockService.getAllProposedStockSummaryByRequestNumber(requestNumberIf);
        return new BaseResponse(proposedStockSummary,HttpStatus.OK.toString());
    }
    @PostMapping
    public BaseResponse<ProposedStock> addProposedStock(@RequestBody ProposedStockDTO proposedStockDTO) throws URISyntaxException {
        proposedStockDTO.setDateStamp(new Date());
        ProposedStock proposedStock = proposedStockService.addProposedStock(proposedStockDTO);
        if(proposedStock!=null){
            return new BaseResponse(proposedStock,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }

    }

    @PutMapping
    public BaseResponse<ProposedStock> updateProposedStock(@RequestBody ProposedStockDTO proposedStockDTO) throws URISyntaxException {
        proposedStockDTO.setDateStamp(new Date());
        if(proposedStockDTO!=null && "D".equalsIgnoreCase(proposedStockDTO.getOperation()) ){
            proposedStockDTO.setOperation("D");
        }else{
            proposedStockDTO.setOperation("U");
        }
        ProposedStock proposedStock = proposedStockService.updateProposedStock(proposedStockDTO);
        if(proposedStock!=null){
            return new BaseResponse(proposedStock,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

    @DeleteMapping("/{proposedStockId}")
    public BaseResponse<String> deleteProposedStock(@PathVariable("proposedStockId") Long proposedStockId) throws URISyntaxException {
        String proposedStock = proposedStockService.deleteProposedStock(proposedStockId);
        return new BaseResponse(proposedStock,HttpStatus.OK.toString());
    }

    @PostMapping("/save-technical-study")
    public BaseResponse<TechnicalStudySummary> saveProposedProjectEquip(@RequestBody ProposedStockSummary proposedStockSummary) {
        TechnicalStudySummary technicalStudySummary = technicalStudySummaryService.saveTechnicalStudySummaryFromProposedProject(proposedStockSummary);
        return new BaseResponse<TechnicalStudySummary>(technicalStudySummary,HttpStatus.OK.toString());
    }

}
