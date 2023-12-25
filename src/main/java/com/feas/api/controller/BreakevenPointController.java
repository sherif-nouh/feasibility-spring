package com.feas.api.controller;

import com.feas.domain.entity.dto.BreakevenPointCustom;
import com.feas.domain.entity.dto.BreakevenPointCustomDTO;
import com.feas.domain.entity.dto.ProposedCarrierSummary;
import com.feas.service.impl.BreakevenPointService;
import com.feas.service.model.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ١٦/٠٢/٢٠٢٣
 */
@RestController
@Tag(name = "breakeven-point", description = "N_BREAKEVEN_POINT  - المؤشرات الاقتصادية - حد الإنتاج الذي لا يحقق ربح أوخسارة ")
@RequestMapping("/breakeven-point")
public class BreakevenPointController {
    private final BreakevenPointService breakevenPointService;

    public BreakevenPointController(BreakevenPointService breakevenPointService) {
        this.breakevenPointService = breakevenPointService;
    }

    @GetMapping()
    @ResponseBody
    public BaseResponse<BreakevenPointCustomDTO> getBreakEvenPointCustomEntity(
            @RequestParam(defaultValue = "-1") BigDecimal requestNumber,
            @RequestParam(defaultValue = "-1") BigDecimal licenseNumber) {
        BreakevenPointCustomDTO breakEvenPointCustomEntity = breakevenPointService.getBreakEvenPointCustomEntity(requestNumber, licenseNumber);
        return new BaseResponse<BreakevenPointCustomDTO>(breakEvenPointCustomEntity, HttpStatus.OK.toString());

    }
}
