package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٤/٠٧/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProposedStockSummary {
    private BigDecimal cifAvailMatSummary;
    private BigDecimal locAvailMatSummary;
    private BigDecimal transportationExp;
    private BigDecimal sumTotal;
    private BigDecimal sumPacking;
    private BigDecimal ratioLocTotal;
    private String remarksByDept;
    private BigDecimal sumStock;
    private BigDecimal reqHandlerIf;
    private Long requestNumberIf;
    private Long licenseNumberIf;
}
