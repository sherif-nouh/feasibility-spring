package com.feas.api.controller;

import com.feas.domain.entity.ProposedManpower;
import com.feas.domain.entity.RawMaterialStorage;
import com.feas.domain.entity.dto.ProposedManpowerDTO;
import com.feas.domain.entity.dto.RawMaterialStorageDTO;
import com.feas.domain.entity.dto.SumRawMaterial;
import com.feas.domain.entity.dto.SumRawMaterialDTO;
import com.feas.service.impl.RawMaterialStorageService;
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
 * @Date ٠٧/٠٢/٢٠٢٣
 */
@RestController()
@RequestMapping("/raw-material-storage")
@Tag(name = "raw-material-storage", description = "N_RAWMATERIAL_STORAGE -   المواد الاولية اللازمة للانتاج و مساحات التخزين اللازمة لها")
public class RawMaterialStorageController {

    private final RawMaterialStorageService rawMaterialStorageService;

    public RawMaterialStorageController(RawMaterialStorageService rawMaterialStorageService) {
        this.rawMaterialStorageService = rawMaterialStorageService;
    }

    @GetMapping
    public BaseResponse<List<RawMaterialStorage>> getAllRawMaterialStorageByRequestNumber(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        List<RawMaterialStorage> allRawMaterialStorageByRequestNumber = rawMaterialStorageService.getAllRawMaterialByRequestNumber(requestNumberIf);
        return new BaseResponse<>(allRawMaterialStorageByRequestNumber, HttpStatus.OK.toString());
    }
    @GetMapping("/page")
    public BaseResponse<Page<RawMaterialStorage>> getAllRawMaterialStorageByRequestNumberAsPage(
            @RequestParam(defaultValue = "-1") BigDecimal requestNumberIf,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<RawMaterialStorage> allRawMaterialStorageByRequestNumber = rawMaterialStorageService.getAllRawMaterialStorageByRequestNumberAsPage(requestNumberIf,pageable);
        return new BaseResponse<>(allRawMaterialStorageByRequestNumber, HttpStatus.OK.toString());
    }

    @GetMapping("/sum-raw-material")
    public BaseResponse<SumRawMaterialDTO> getSumRawMaterial(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf){
        SumRawMaterialDTO sumRawMaterial = rawMaterialStorageService.getSumRawMaterial(requestNumberIf);
        return new BaseResponse(sumRawMaterial, HttpStatus.OK.toString());
    }

    @PostMapping
    public BaseResponse<RawMaterialStorage> addRawMaterialStorage(@RequestBody RawMaterialStorageDTO rawMaterialStorageDTO) throws URISyntaxException {
        rawMaterialStorageDTO.setDateStamp(new Date());
        RawMaterialStorage rawMaterialStorage = rawMaterialStorageService.addRawMaterialStorage(rawMaterialStorageDTO);
        if(rawMaterialStorage!=null){
            return new BaseResponse(rawMaterialStorage,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

    @PutMapping
    public BaseResponse<RawMaterialStorage> editProposedManpower(@RequestBody RawMaterialStorageDTO rawMaterialStorageDTO) throws URISyntaxException {
        rawMaterialStorageDTO.setDateStamp(new Date());
        if(rawMaterialStorageDTO!=null && "D".equalsIgnoreCase(rawMaterialStorageDTO.getOperation()) ){
            rawMaterialStorageDTO.setOperation("D");
        }else{
            rawMaterialStorageDTO.setOperation("U");
        }
        RawMaterialStorage rawMaterialStorage = rawMaterialStorageService.updateRawMaterialStorage(rawMaterialStorageDTO);
        if(rawMaterialStorage!=null){
            return new BaseResponse(rawMaterialStorage,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

    @DeleteMapping
    public BaseResponse<String> deleteProposedManpower(@PathVariable Long proposedManpowerId) throws URISyntaxException {
        String proposedManpower = rawMaterialStorageService.deleteRawMaterialStorage(proposedManpowerId);
        return new BaseResponse(proposedManpower,HttpStatus.OK.toString());
    }


}
