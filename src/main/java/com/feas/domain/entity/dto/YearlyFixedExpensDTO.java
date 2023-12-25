package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٢/٠٢/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class YearlyFixedExpensDTO {

    private long projectNumberIf;

    private long requestNumberIf;

    private long licenseNumberIf;
    private BigDecimal advertExpCy;

    private BigDecimal allowancesCy;

    private BigDecimal allpercIndmanpCostCy;

    private BigDecimal auditExpCy;

    private Date dateStamp;

    private BigDecimal genExpCy;

    private BigDecimal indSpaceRentCy;

    private BigDecimal insuExpBuildtoolsCy;

    private BigDecimal insuPercexpBuildtoolsCy;

    private BigDecimal nonroutineMaintExpCy;

    private String operation;

    private BigDecimal otherExpCy;

    private BigDecimal profitsNotinclProdCy;

    private BigDecimal salariesCy;

    private BigDecimal trvlAllwConsultExpCy;

    private String userName;

    private BigDecimal vehInsurCy;
    private BigDecimal insurance;
    private BigDecimal totalYearlyFixedExpenses;
}
