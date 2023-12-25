package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٢/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SumGeneralFacilityDTO implements SumGeneralFacility {

    private BigDecimal totalNonProductive;
    private BigDecimal totalProductive;
    private BigDecimal totalGeneralFacility;
    private BigDecimal requestNumberIf;


}
