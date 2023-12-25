package com.feas.api.controller;

import com.feas.domain.entity.ProposedGeneralFacility;
import com.feas.domain.entity.YearlyVariableExpens;
import com.feas.domain.entity.dto.ProposedGeneralFacilityDTO;
import com.feas.service.impl.YearlyVariableExpensService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ١٩/٠٣/٢٠٢٣
 */

@RestController()
@RequestMapping("/yearly-variable-expens")
@Tag(name = "yearly-variable-expens", description = "N_YEARLY_VARIABLE_EXPENSES -  تكاليف الإنتاج السنوى/مصاريف التشغيل السنوية/المصاريف المتغيرة السنوية")
public class YearlyVariableExpensController {

    private final YearlyVariableExpensService yearlyVariableExpensService;

    public YearlyVariableExpensController(YearlyVariableExpensService yearlyVariableExpensService) {
        this.yearlyVariableExpensService = yearlyVariableExpensService;
    }

    @GetMapping
    @ResponseBody
    @Tag( name = "yearly-variable-expens")
    public BaseResponse<YearlyVariableExpens> gelAllYearlyVariableExpensByRequestAndLicence(@RequestParam(defaultValue = "-1") long requestNumberIf,
                                                                                                 @RequestParam(defaultValue = "-1") long licenseNumberId){
         return new BaseResponse<>( yearlyVariableExpensService.gelAllYearlyVariableExpensByRequestAndLicence(requestNumberIf,licenseNumberId), HttpStatus.OK.toString());
    }

    @PutMapping
    public BaseResponse<YearlyVariableExpens> saveYearlyVariableExpens(@RequestBody YearlyVariableExpens yearlyVariableExpens) {
        yearlyVariableExpens.setDateStamp(new Date());
        YearlyVariableExpens yearlyVariableExpens1 = yearlyVariableExpensService.saveYearlyVariableExpense(yearlyVariableExpens);
        return new BaseResponse<>( yearlyVariableExpens1, HttpStatus.OK.toString());
    }

}
