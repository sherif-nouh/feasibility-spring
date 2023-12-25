package com.feas.domain.entity.dto;

import com.feas.domain.entity.ProductionLineArea;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sherif Nouh
 * @Date ٠٨/٠٢/٢٠٢٣
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductionLineAreaWithSummeryFields {

    private List<ProductionLineArea> productionLineAreas;
    private BigDecimal sumTotal;
    private BigDecimal sumVSummary;
}
