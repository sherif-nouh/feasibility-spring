package com.feas.api.controller;

import com.feas.domain.entity.FinishedGoodsStorage;
import com.feas.domain.entity.GeneralInformation;
import com.feas.domain.entity.dto.FinishedGoodsStorageDTO;
import com.feas.domain.entity.dto.GeneralInformationDTO;
import com.feas.service.impl.GeneralInformationService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

@RestController
@RequestMapping("/general-information")
@Tag(name = "general-information", description = "N_GENERAL_INFORMATION - بيانات عامة عن المنشأة الصناعية من واقع الطلب")
public class GeneralInformationController {

    private final GeneralInformationService generalInformationService;

    public GeneralInformationController(GeneralInformationService generalInformationService) {
        this.generalInformationService = generalInformationService;
    }

    /*@GetMapping("/")
    @ResponseBody
    @RequestMapping( method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public BaseResponse<GeneralInformation> getByLicenceNumberIf(@RequestParam Long licenseNumberIf){
        return new BaseResponse<>(generalInformationService.getById(licenseNumberIf).get(), HttpStatus.OK.toString());
    }*/

    @GetMapping
    @ResponseBody
   // @RequestMapping( method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public BaseResponse<GeneralInformation> getById( @RequestParam(defaultValue = "-1") Long licenseNumberIf){
        return new BaseResponse<>(generalInformationService.getById(licenseNumberIf).orElseGet(() -> new GeneralInformation()), HttpStatus.OK.toString());
    }
    @GetMapping("/{licenseNumberIf}")
    @ResponseBody
    // @RequestMapping( method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public BaseResponse<GeneralInformation> getByIdOne( @PathVariable(name = "licenseNumberIf") Long licenseNumberIf){
        return new BaseResponse<>(generalInformationService.getById(licenseNumberIf).orElseGet(() -> new GeneralInformation()), HttpStatus.OK.toString());
    }
    @PutMapping
    public BaseResponse<GeneralInformation> editProposedManpower(@RequestBody GeneralInformationDTO generalInformationDTO) throws URISyntaxException {
        generalInformationDTO.setActionDt(new Date());
        if(generalInformationDTO!=null && "D".equalsIgnoreCase(generalInformationDTO.getAction()) ){
            generalInformationDTO.setAction("D");
        }else{
            generalInformationDTO.setAction("U");
        }
        GeneralInformation generalInformation = generalInformationService.updateGeneralInformation(generalInformationDTO);
        if(generalInformation!=null){
            return new BaseResponse(generalInformation,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
    @PostMapping
    public BaseResponse<GeneralInformation> addProposedManpower(@RequestBody GeneralInformationDTO generalInformationDTO) throws URISyntaxException {
        generalInformationDTO.setActionDt(new Date());
        GeneralInformation generalInformation = generalInformationService.updateGeneralInformation(generalInformationDTO);
        if(generalInformation!=null){
            return new BaseResponse(generalInformation,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

}
