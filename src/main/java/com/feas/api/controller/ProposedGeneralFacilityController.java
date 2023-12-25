package com.feas.api.controller;

import com.feas.domain.entity.ProposedGeneralFacility;
import com.feas.domain.entity.ProposedManpower;
import com.feas.domain.entity.dto.ProposedGeneralFacilityDTO;
import com.feas.domain.entity.dto.ProposedManpowerDTO;
import com.feas.domain.entity.dto.SumGeneralFacility;
import com.feas.domain.entity.dto.SummaryLabour;
import com.feas.service.impl.ProposedGeneralFacilityService;
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
 * @Date ٠٥/٠٢/٢٠٢٣
 */
@RestController
@RequestMapping("/proposed-general-facility")
@Tag(name = "proposed-general-facility", description = "N_PROPOSED_GENERAL_FACILITY -   منافع العامة")
public class ProposedGeneralFacilityController {

    private final ProposedGeneralFacilityService proposedGeneralFacilityService;


    public ProposedGeneralFacilityController(ProposedGeneralFacilityService proposedGeneralFacilityService) {
        this.proposedGeneralFacilityService = proposedGeneralFacilityService;
    }

    @GetMapping
    public BaseResponse<List<ProposedGeneralFacility>> getAllManPowerByRequestNumber(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        List<ProposedGeneralFacility> allProposedGeneralFacilityByRequestNumber = proposedGeneralFacilityService.getAllProposedGeneralFacilityByRequestNumber(requestNumberIf);
        return new BaseResponse<>(allProposedGeneralFacilityByRequestNumber, HttpStatus.OK.toString());
    }
    @GetMapping("/page")
    public BaseResponse<Page<ProposedGeneralFacility>> getAllManPowerByRequestNumberAsPage(
            @RequestParam(defaultValue = "-1") BigDecimal requestNumberIf,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<ProposedGeneralFacility> allProposedGeneralFacilityByRequestNumber = proposedGeneralFacilityService.getAllProposedGeneralFacilityByRequestNumberAsPage(requestNumberIf,pageable);
        return new BaseResponse<>(allProposedGeneralFacilityByRequestNumber, HttpStatus.OK.toString());
    }

    @GetMapping("/sum-general-facility")
    public BaseResponse<SumGeneralFacility> getSumGeneralFacility(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        SumGeneralFacility sumGeneralFacility = proposedGeneralFacilityService.getSumGeneralFacility(requestNumberIf);
        return new BaseResponse(sumGeneralFacility,HttpStatus.OK.toString());
    }

    @PostMapping
    public BaseResponse<ProposedGeneralFacility> addProposedGeneralFacility(@RequestBody ProposedGeneralFacilityDTO proposedGeneralFacilityDTO) throws URISyntaxException {

        ProposedGeneralFacility proposedGeneralFacility = proposedGeneralFacilityService.addProposedGeneralFacility(proposedGeneralFacilityDTO);
        if(proposedGeneralFacility!=null){
            return new BaseResponse(proposedGeneralFacility,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }

    }

    @PutMapping
    public BaseResponse<ProposedGeneralFacility> editProposedGeneralFacility(@RequestBody ProposedGeneralFacilityDTO proposedGeneralFacilityDTO) throws URISyntaxException {

        ProposedGeneralFacility proposedGeneralFacility = proposedGeneralFacilityService.updateProposedGeneralFacility(proposedGeneralFacilityDTO);
        proposedGeneralFacility.setDateStamp(new Date());
        if(proposedGeneralFacility!=null){
            return new BaseResponse(proposedGeneralFacility,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

    @DeleteMapping
    public BaseResponse<String> deleteProposedGeneralFacility(@PathVariable Long proposedManpowerId) throws URISyntaxException {
        String proposedManpower = proposedGeneralFacilityService.deleteProposedGeneralFacility(proposedManpowerId);
        return new BaseResponse(proposedManpower,HttpStatus.OK.toString());
    }

}
