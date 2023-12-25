package com.feas.api.controller;

import com.feas.domain.entity.EconomicalStudySummary;
import com.feas.domain.entity.YearlyVariableExpens;
import com.feas.domain.entity.dto.YearlyFixedVariableExpenseDTO;
import com.feas.service.impl.YearlyFixedVariableExpService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Sherif Nouh
 * @Date ٢٧/٠٣/٢٠٢٣
 */

@RestController()
@RequestMapping("/yearly-fixed-variable-exp")
@Tag(name = "yearly-fixed-variable-exp", description = "N_YEARLY_FIXED_VARIABLE_EXP -  تكاليف الإنتاج السنوى/تكاليف الانتاج ")
public class YearlyFixedVariableExpensesController {

    private final YearlyFixedVariableExpService yearlyFixedVariableExpService;

    public YearlyFixedVariableExpensesController(YearlyFixedVariableExpService yearlyFixedVariableExpService) {
        this.yearlyFixedVariableExpService = yearlyFixedVariableExpService;
    }


    @GetMapping
    @ResponseBody
    public BaseResponse<YearlyFixedVariableExpenseDTO> gelAllYearlyFixedVariableExpByRequestAndLicence(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf,
                                                                                                       @RequestParam(defaultValue = "-1") BigDecimal licenseNumberIf){
        return new BaseResponse<>( yearlyFixedVariableExpService.getYearlyFixedVariableExpenseDTO(requestNumberIf,licenseNumberIf), HttpStatus.OK.toString());
    }

    @PutMapping
    public BaseResponse<YearlyFixedVariableExpenseDTO> saveYearlyFixedVariableExp(@RequestBody YearlyFixedVariableExpenseDTO yearlyFixedVariableExpenseDTO) throws URISyntaxException {
        EconomicalStudySummary economicalStudySummary = yearlyFixedVariableExpService.saveYearlyFixedVariableExpExpense(yearlyFixedVariableExpenseDTO);
        if (economicalStudySummary!=null){
            return new BaseResponse<>( yearlyFixedVariableExpenseDTO, HttpStatus.OK.toString());
        }
        return new BaseResponse<>( null, HttpStatus.OK.toString());
    }

}
