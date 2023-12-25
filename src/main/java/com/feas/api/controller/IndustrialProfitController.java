package com.feas.api.controller;

import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.dto.CalculateIndustrialCost;
import com.feas.domain.entity.dto.IndustrialProfitROVODTO;
import com.feas.domain.entity.dto.YearlyFixedVariableExpenseDTO;
import com.feas.service.impl.IndustrialProfitROVOService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٨/٢٠٢٣
 */
@RestController
@RequestMapping("/industrial-profit")
@Tag(name = "industrial-profit", description = "N_INDUSTRIAL_PROFIT -المؤشرات الإقتصادية - إجمالي القيمة المضافة للدخل القومي/الأرباح الصناعية")
public class IndustrialProfitController {

    private final IndustrialProfitROVOService industrialProfitROVOService;

    public IndustrialProfitController(IndustrialProfitROVOService industrialProfitROVOService) {
        this.industrialProfitROVOService = industrialProfitROVOService;
    }

    @GetMapping
    @ResponseBody
    public BaseResponse<IndustrialProfitROVODTO> getIndustrialProfitROVO(
            @RequestParam(defaultValue = "-1") long requestNumberIf,
            @RequestParam(defaultValue = "-1") long licenseNumberIf){
        IndustrialProfitROVODTO industrialProfitROVODTO = industrialProfitROVOService.getIndustrialProfitROVO(requestNumberIf,licenseNumberIf);
        return new BaseResponse<>(industrialProfitROVODTO, HttpStatus.OK.toString());
    }

    @PutMapping
    public BaseResponse<IndustrialProfitROVODTO> updateYearlyDeprecation(@RequestBody IndustrialProfitROVODTO industrialProfitROVODTO) {
        EconomicalStudySummary save = industrialProfitROVOService.saveEconomicStudy(industrialProfitROVODTO);
        if(save!=null){
            return new BaseResponse(industrialProfitROVODTO,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
}
