package com.feas.api.controller;

import com.feas.domain.entity.ProductionLineArea;
import com.feas.domain.entity.ProposedManpower;
import com.feas.domain.entity.dto.ProductionLineAreaWithSummeryFields;
import com.feas.domain.entity.dto.TempRequestDTO;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.service.impl.ProductionLineAreaService;
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
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٠٨/٠٢/٢٠٢٣
 */
@RestController
@RequestMapping("/production-line-area")
@Tag(name = "production-line-area", description = "N_PRODUCTION_LINE_AREA -  المساحة اللازمة لصالة الإنتاج")
public class ProductionLineAreaController {
    private final ProductionLineAreaService productionLineAreaService;

    public ProductionLineAreaController(ProductionLineAreaService productionLineAreaService) {
        this.productionLineAreaService = productionLineAreaService;
    }

    @GetMapping
    public BaseResponse<List<ProductionLineArea>> getAllManPowerByRequestNumber(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf, @RequestParam(defaultValue = "-1") BigDecimal licenseNumberIf){
        List<ProductionLineArea> allProductionLineAreaWithSummeryFieldsByRequestNumber = productionLineAreaService.getAllProductionLineAreaByRequestNumber(requestNumberIf,licenseNumberIf);
        return new BaseResponse<>(allProductionLineAreaWithSummeryFieldsByRequestNumber, HttpStatus.OK.toString());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public BaseResponse<ProductionLineArea> getOneById(@PathVariable Long id) throws Exception {
        Optional<ProductionLineArea> productionLineArea= productionLineAreaService.findById(id);
        return new BaseResponse<ProductionLineArea>(productionLineArea.orElseThrow(() -> new Exception(" not found - " + id)),HttpStatus.OK.toString());
    }

    @PostMapping
    public BaseResponse<ProductionLineArea> createProductionLineArea(@RequestBody ProductionLineArea productionLineArea) throws URISyntaxException {
        productionLineArea.setDateStamp(new Date());
        ProductionLineArea productionLineArea1 = productionLineAreaService.save(productionLineArea);
        if(productionLineArea1!=null){
            return new BaseResponse(productionLineArea1,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }


    @PutMapping
    public BaseResponse<ProductionLineArea> updateProductionLineArea( @RequestBody ProductionLineArea productionLineArea) {
        productionLineArea.setDateStamp(new Date());
        if(productionLineArea!=null && "D".equalsIgnoreCase(productionLineArea.getOperation()) ){
            productionLineArea.setOperation("D");
        }else{
            productionLineArea.setOperation("U");
        }
        ProductionLineArea productionLineArea1 = productionLineAreaService.save(productionLineArea);
        if(productionLineArea1!=null){
            return new BaseResponse(productionLineArea1,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

    @PutMapping("/summary-fields")
    @ResponseBody
    public BaseResponse updateProductionLineAreaSummary(@RequestBody TempRequestDTO tempRequestDTO)throws URISyntaxException {
        TempRequest tempRequest = productionLineAreaService.updateSummaryFields(tempRequestDTO);
        if(tempRequest!=null){
            return new BaseResponse(tempRequest,HttpStatus.CREATED.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
}
