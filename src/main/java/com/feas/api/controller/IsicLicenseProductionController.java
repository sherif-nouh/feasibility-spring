package com.feas.api.controller;

import com.feas.domain.entity.IsicLicenseProduction;
import com.feas.domain.entity.lookups.RemarksTech;
import com.feas.service.impl.IsicLicenseProductionService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٢/٠٦/٢٠٢٣
 */
@RestController()
@RequestMapping("/isic-production")
@Tag(name = "isic-production", description = "isic-production -   كود الايزك والنشاط")
public class IsicLicenseProductionController {

    private final IsicLicenseProductionService isicLicenseProductionService;

    public IsicLicenseProductionController(IsicLicenseProductionService isicLicenseProductionService) {
        this.isicLicenseProductionService = isicLicenseProductionService;
    }

    @PostMapping
    public BaseResponse<IsicLicenseProduction> addRemarksTech(@RequestBody IsicLicenseProduction isicLicenseProduction) throws URISyntaxException {
        isicLicenseProduction.setActionDate(new Date());
        IsicLicenseProduction isicLicenseProduction1 = isicLicenseProductionService.saveNew(isicLicenseProduction);
        if(isicLicenseProduction1!=null){
            return new BaseResponse(isicLicenseProduction1, HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
    @PutMapping
    public BaseResponse<IsicLicenseProduction> updateRemarksTech(@RequestBody IsicLicenseProduction isicLicenseProduction) throws URISyntaxException {
        isicLicenseProduction.setActionDate(new Date());
        if(isicLicenseProduction!=null && "D".equalsIgnoreCase(isicLicenseProduction.getOperation()) ){
            isicLicenseProduction.setOperation("D");
        }else{
            isicLicenseProduction.setOperation("U");
        }
        IsicLicenseProduction isicLicenseProduction1  = isicLicenseProductionService.saveNew(isicLicenseProduction);
        if(isicLicenseProduction1!=null){
            return new BaseResponse(isicLicenseProduction1, HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
    @DeleteMapping
    public ResponseEntity<IsicLicenseProduction> deleteRemarksTech(@RequestBody IsicLicenseProduction isicLicenseProduction) throws URISyntaxException {
        IsicLicenseProduction isicLicenseProduction1 = isicLicenseProductionService.deleteRecord(isicLicenseProduction);
        return ResponseEntity.created(new URI("/isic-production/" + isicLicenseProduction1.getLicenseProductionId())).body(isicLicenseProduction1);
    }
}
