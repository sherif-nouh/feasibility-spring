package com.feas.api.controller;

import com.feas.domain.entity.ProjectSetupCost;
import com.feas.domain.entity.dto.OperatingCapitalROV;
import com.feas.domain.entity.dto.OperatingCapitalROVDTO;
import com.feas.service.impl.OperatingCapitalService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@RestController
@RequestMapping("/operation-capital")
@Tag(name = "operation-capital", description = "N_OPERATING_CAPITAL -  تقديرات رأس المال العامل/اجمالي الإستثمارات")
public class OperatingCapitalController {


    private final OperatingCapitalService operatingCapitalService;

    public OperatingCapitalController(OperatingCapitalService operatingCapitalService) {
        this.operatingCapitalService = operatingCapitalService;
    }

    @GetMapping
    @ResponseBody
    public BaseResponse<OperatingCapitalROVDTO> geProjectSetupCostByRequest(
            @RequestParam(defaultValue = "-1") BigDecimal requestNumberIf) {
        OperatingCapitalROVDTO operatingCapitalROVDTO = operatingCapitalService.getOperatingCapitalROV(requestNumberIf);
        return new BaseResponse<>(operatingCapitalROVDTO, HttpStatus.OK.toString());

    }


    @PutMapping("/{requestNumber}")
    public BaseResponse updateOperationCapital(@PathVariable  String requestNumber ,@RequestBody OperatingCapitalROV operatingCapitalROV) {
        if(operatingCapitalROV!=null){
            return new BaseResponse(operatingCapitalROV,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
}
