package com.feas.api.controller;

import com.feas.domain.entity.ProposedCarrier;
import com.feas.domain.entity.dto.ProposedCarrierDTO;
import com.feas.domain.entity.dto.ProposedCarrierSummary;
import com.feas.persistence.repository.ProposedCarrierRepository;
import com.feas.service.impl.ProposedCarrierService;
import com.feas.service.mapper.ServiceObjectMapperImpl;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proposed-carrier")
@Tag(name = "proposed-carrier", description = "N_PROPOSED_CARRIER -   تابع الآلآت والمعدات")
public class ProposedCarrierController {

    private final ProposedCarrierService proposedCarrierService;
    private final ProposedCarrierRepository proposedCarrierRepository;
    @Autowired
    private final ServiceObjectMapperImpl modelMapper;
    public ProposedCarrierController(ProposedCarrierService proposedCarrierService, ServiceObjectMapperImpl modelMapper,ProposedCarrierRepository proposedCarrierRepository) {
        this.proposedCarrierService = proposedCarrierService;
        this.modelMapper = modelMapper;
        this.proposedCarrierRepository = proposedCarrierRepository;
    }

    @GetMapping
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public BaseResponse<List<ProposedCarrier>> getAllByLicAndReq(
            @RequestParam(defaultValue = "-1") Long requestNumberIf,
            @RequestParam(defaultValue = "-1") Long licenseNumberIf) {
        List<ProposedCarrier> queryAll = proposedCarrierService.queryAll(licenseNumberIf,requestNumberIf);
        return new BaseResponse<List<ProposedCarrier>>(queryAll, HttpStatus.OK.toString());

    }

    @GetMapping("/summary")
    @ResponseBody
    public BaseResponse<ProposedCarrierSummary> getAllSummaryFields(
            @RequestParam(defaultValue = "-1") Long requestNumberIf) {
        ProposedCarrierSummary summaryFields = proposedCarrierService.getProposedCarrierInternalExternalTransport(requestNumberIf);
        return new BaseResponse<ProposedCarrierSummary>(summaryFields, HttpStatus.OK.toString());

    }

    @GetMapping("/{id}")
    @ResponseBody
    public BaseResponse<ProposedCarrier> getOneById( @PathVariable Long id) throws Exception {
        Optional<ProposedCarrier> proposedCarrier= proposedCarrierService.findById(id);
        return new BaseResponse<ProposedCarrier>(proposedCarrier.orElseThrow(() -> new Exception(" not found - " + id)),HttpStatus.OK.toString());
    }

    @PostMapping
    public BaseResponse<ProposedCarrier> createProposedCarrier(@RequestBody ProposedCarrierDTO proposedCarrier) throws URISyntaxException {
        ProposedCarrier map = modelMapper.map(proposedCarrier, ProposedCarrier.class);
        map.setDateStamp(new Date());
        map.setManufCtry(null);
        map.setVehicalCode(null);
        map.setQuantityApproved(map.getQuantityNr()==null?new BigDecimal(0):map.getQuantityNr());
        map.setVehType(null);
        ProposedCarrier savedProposedProject = proposedCarrierRepository.save(map);
        if(savedProposedProject!=null){
            return new BaseResponse(savedProposedProject, HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }



    @PutMapping
    public BaseResponse<ProposedCarrier> updateProposedCarrier( @RequestBody ProposedCarrierDTO proposedCarrier) {
        ProposedCarrier map = modelMapper.map(proposedCarrier, ProposedCarrier.class);
        int udatedRecord=0;
        if(proposedCarrier!=null && "D".equalsIgnoreCase(proposedCarrier.getOperation()) ){
            proposedCarrier.setOperation("D");
            udatedRecord = proposedCarrierRepository.deleteFromProposedCarrier(proposedCarrier.getProposedCarrierId());
        }else{
            proposedCarrier.setOperation("U");
            udatedRecord=proposedCarrierService.updateFromProposedCarrier(proposedCarrier);
        }
        //proposedCarrier.setDateStamp(new Date());
       // ProposedCarrier prop = proposedCarrierService.save(proposedCarrier);
        /* prop = proposedCarrierRepository.save(map);*/
        if(udatedRecord !=0){
            return new BaseResponse(map,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }


}
