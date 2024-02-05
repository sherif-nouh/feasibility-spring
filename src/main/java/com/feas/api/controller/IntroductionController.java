package com.feas.api.controller;

import com.feas.domain.entity.EstimatedYearlySales;
import com.feas.domain.entity.Introduction;
import com.feas.domain.entity.dto.EstimatedYearlySaleDTO;
import com.feas.service.impl.IntroducationService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ١٦/٠٢/٢٠٢٣
 */
@RestController
@Tag(name = "Introduction", description = "N_Introduction  - المقدمة  ")
@RequestMapping("/Introduction")
public class IntroductionController {
    private final IntroducationService introducationService;


    public IntroductionController(IntroducationService introducationService) {
        this.introducationService = introducationService;
    }


    @GetMapping()
    @ResponseBody
    public BaseResponse< List<Introduction>> getIntroductionEntity(
            @RequestParam(defaultValue = "-1") BigDecimal requestNumber,
            @RequestParam(defaultValue = "-1") BigDecimal licenseNumber) {
       List<Introduction> breakEvenPointCustomEntity = introducationService.getIntroductionOrCreateNew(requestNumber, licenseNumber);
        return new BaseResponse<>( breakEvenPointCustomEntity,HttpStatus.OK.toString());

    }
    @PostMapping
    public BaseResponse<Introduction> addEstimatedYearlySale(@RequestBody Introduction estimatedYearlySaleDTO) throws URISyntaxException {
        estimatedYearlySaleDTO.setDateStamp(new Date());
        Introduction proposedStock = introducationService.saveIntroduction(estimatedYearlySaleDTO);
        if(proposedStock!=null){
            return new BaseResponse(proposedStock,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }


    }

}
