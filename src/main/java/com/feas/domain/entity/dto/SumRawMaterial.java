package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٧/٠٢/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SumRawMaterial implements SumRawMaterialDTO{

    private BigDecimal totalArea;
    private BigDecimal percTotal;
    private BigDecimal sumTotalArea;
    private BigDecimal requestNumberIf;


}
