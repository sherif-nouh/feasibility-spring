package com.feas.api.controller;

import com.feas.domain.entity.ProposedProjectEquipment;
import com.feas.domain.entity.ValAddedNi;
import com.feas.domain.entity.YearlyFixedExpens;
import com.feas.domain.entity.dto.ValAddedNiReadOnlyFields;
import com.feas.domain.entity.dto.ValAddedNiReadOnlyFieldsDTO;
import com.feas.domain.entity.dto.YearlyFixedExpensDTO;
import com.feas.service.impl.ValAddedNiService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٠٦/٠٣/٢٠٢٣
 */
@RestController
@RequestMapping("/val-added-ni")
@Tag(name = "val-added-ni", description = "N_VAL_ADDED_NI -   صافي أرباح المشروع/صافي القيمة المضافة للدخل القومى")
public class ValAddedNiController {

    private final ValAddedNiService valAddedNiService;

    public ValAddedNiController(ValAddedNiService valAddedNiService) {
        this.valAddedNiService = valAddedNiService;
    }

    @GetMapping("/read-only-fields")
    @ResponseBody
    public BaseResponse<ValAddedNiReadOnlyFields> getAllValAddedNiReadOnlyFields(
            @RequestParam(defaultValue = "-1") BigDecimal requestNumberIf,
            @RequestParam(defaultValue = "-1") BigDecimal licenseNumberIf) {
        ValAddedNiReadOnlyFields allValAddedNiReadOnlyFields = valAddedNiService.getAllValAddedNiReadOnlyFields(requestNumberIf, licenseNumberIf);
        return new BaseResponse<>(allValAddedNiReadOnlyFields, HttpStatus.OK.toString());
    }

    @PutMapping
    public BaseResponse<ValAddedNiReadOnlyFieldsDTO> updateYearlyFixedExpens(@RequestBody ValAddedNiReadOnlyFieldsDTO valAddedNiReadOnlyFields) {
        ValAddedNi save = valAddedNiService.save(valAddedNiReadOnlyFields);
        if(save!=null){
            return new BaseResponse(valAddedNiReadOnlyFields,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }


}
