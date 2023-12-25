package com.feas.domain.entity.dto;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ١٩/٠٣/٢٠٢٣
 */
public interface CalculatedYearlyVariableExpense {

    public BigDecimal getTotal5Perc() ;

    public BigDecimal getTotalMaintenance() ;

    public BigDecimal getIndirectLabour() ;

    public BigDecimal getYearlyVariableExpenses();


}
