package com.feas.api.controller;

import com.feas.domain.entity.ProposedCarrier;
import com.feas.domain.entity.YearlyFixedExpens;
import com.feas.domain.entity.YearlyFixedExpensPK;
import com.feas.domain.entity.dto.YearlyFixedExpensDTO;
import com.feas.domain.entity.dto.YearlyFixedExpensRequest;
import com.feas.domain.entity.dto.YearlyFixedExpensRequestDTO;
import com.feas.service.impl.YearlyFixedExpensService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Sherif Nouh
 * @Date ٢٢/٠٢/٢٠٢٣
 */
@RestController
@RequestMapping("/yearly-fixed-expens")
@Tag(name = "yearly-fixed-expens", description = "N_YEARLY_FIXED_EXPENSES -  مصاريف التشغيل السنوية/المصاريف الثابة السنوية")
public class YearlyFixedExpensController {

    private final YearlyFixedExpensService yearlyFixedExpensService;

    public YearlyFixedExpensController(YearlyFixedExpensService yearlyFixedExpensService) {
        this.yearlyFixedExpensService = yearlyFixedExpensService;
    }

    @GetMapping
    public BaseResponse<YearlyFixedExpensRequestDTO> getYealyFixedExpense(@RequestParam(defaultValue = "-1") BigDecimal requestNumberIf,
                                                                                @RequestParam(defaultValue = "-1") BigDecimal licenseNumberIf){
        return new BaseResponse<>(yearlyFixedExpensService.getYealyFixedExpense(requestNumberIf,licenseNumberIf), HttpStatus.OK.toString());
    }

    @PutMapping
    public BaseResponse<YearlyFixedExpensDTO> updateYearlyFixedExpens(@RequestBody YearlyFixedExpensDTO yearlyFixedExpensDTO) {
        yearlyFixedExpensDTO.setDateStamp(new Date());
        YearlyFixedExpens save = yearlyFixedExpensService.save(yearlyFixedExpensDTO);
        if(save!=null){
            return new BaseResponse(save,HttpStatus.OK.toString());
        }else{
            return new BaseResponse(new BaseResponse<>(null),HttpStatus.BAD_REQUEST.toString());
        }
    }
}
