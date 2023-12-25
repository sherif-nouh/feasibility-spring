package com.feas.api.controller;

import com.feas.domain.entity.FixedAssetsCost;
import com.feas.domain.entity.ProposedCarrier;
import com.feas.domain.entity.dto.FixedAssetsCostDTO;
import com.feas.domain.entity.dto.FixedAssetsCostReadOnlyFields;
import com.feas.domain.entity.dto.FixedAssetsCostReadOnlyFieldsDTO;
import com.feas.domain.entity.dto.ProposedCarrierSummary;
import com.feas.service.impl.FixedAssetsCostService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@RestController
@RequestMapping("/fixed-assets-cost")
@Tag(name = "fixed-assets-cost", description = "N_FIXED_ASSETS_COST - الا ستثمارات اللازمة للمشروع")
public class FixedAssetsCostController {


    private final FixedAssetsCostService fixedAssetsCostService;

    public FixedAssetsCostController(FixedAssetsCostService fixedAssetsCostService) {
        this.fixedAssetsCostService = fixedAssetsCostService;
    }

    @GetMapping
    @ResponseBody
    public BaseResponse<FixedAssetsCostReadOnlyFieldsDTO> getFixedAssetsCostReadOnlyFields(
            @RequestParam(defaultValue = "-1") Long requestNumberIf) {
        FixedAssetsCostReadOnlyFieldsDTO fixedAssetsCostReadOnlyFields = fixedAssetsCostService.getFixedAssetsCostReadOnlyFields(requestNumberIf);
        return new BaseResponse<FixedAssetsCostReadOnlyFieldsDTO>(fixedAssetsCostReadOnlyFields, HttpStatus.OK.toString());

    }

    @PutMapping
    public BaseResponse updateFixedAssetCost( @RequestBody FixedAssetsCostReadOnlyFieldsDTO fixedAssetsCostReadOnlyFields) {
        FixedAssetsCostReadOnlyFieldsDTO save = fixedAssetsCostService.save(fixedAssetsCostReadOnlyFields);
        if(save!=null){
            return new BaseResponse(save,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }

}
