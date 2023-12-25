package com.feas.api.controller;

import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.YearlyFixedExpens;
import com.feas.domain.entity.dto.YearlyDepreciationCustom;
import com.feas.domain.entity.dto.YearlyFixedExpensDTO;
import com.feas.domain.entity.dto.YearlyFixedVariableExpense;
import com.feas.domain.entity.dto.YearlyFixedVariableExpenseDTO;
import com.feas.service.impl.YearlyDepreciationService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٢١/٠٣/٢٠٢٣
 */
@RestController
@RequestMapping("/yearly-deprecation")
@Tag(name = "yearly-deprecation", description = "N_YEARLY_DEPRECIATION -   تكاليف الإنتاج السنوى/الإستهلاكات السنوية")
public class YearlyDepreciationController {

    private final YearlyDepreciationService yearlyDepreciationService;

    public YearlyDepreciationController(YearlyDepreciationService yearlyDepreciationService) {
        this.yearlyDepreciationService = yearlyDepreciationService;
    }

    @GetMapping
    public BaseResponse<YearlyFixedVariableExpenseDTO> getYearlyFixedVariableExpense(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf,
                                                                                  @RequestParam(defaultValue = "-1") BigDecimal licenseNumberIf){
        YearlyFixedVariableExpenseDTO yearlyFixedVariableExpense = yearlyDepreciationService.getYearlyFixedVariableExpense(requestNumberIf, licenseNumberIf);

        return new BaseResponse<>(yearlyFixedVariableExpense, HttpStatus.OK.toString());
    }
    @GetMapping("/deprecation")
    public BaseResponse<YearlyFixedVariableExpense> getYearlyDepercation(@RequestParam(defaultValue = "-1") long requestNumberIf,
                                                                       @RequestParam(defaultValue = "-1") long licenseNumberIf){
        YearlyFixedVariableExpense yearlyFixedVariableExpense = yearlyDepreciationService.getYearlyDepreciationByLicAndReq(requestNumberIf, licenseNumberIf);

        return new BaseResponse<>(yearlyFixedVariableExpense, HttpStatus.OK.toString());
    }

    @PutMapping
    public BaseResponse<YearlyFixedVariableExpenseDTO> updateYearlyDeprecation(@RequestBody YearlyFixedVariableExpenseDTO yearlyFixedVariableExpenseDTO) {
        yearlyFixedVariableExpenseDTO.setOperation("U");
        YearlyFixedVariableExpenseDTO save = yearlyDepreciationService.save(yearlyFixedVariableExpenseDTO);
        if(save!=null){
            return new BaseResponse(save,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
}
