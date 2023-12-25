package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ١٩/٠٣/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalculatedYearlyVariableExpenseDTO implements CalculatedYearlyVariableExpense{

    private BigDecimal total5Perc;
    private BigDecimal totalMaintenance;
    private BigDecimal indirectLabour;
    private BigDecimal yearlyVariableExpenses;


}
