package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٦/٠٧/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectRevenueCustomDTO implements ProjectRevenueCustom{
    private long projectnumberif;
    private long requestnumberif;
    private BigDecimal yrlysalesvalcy;
    private BigDecimal yrlyprodexpcy;

    private BigDecimal percprodlosscy;
    private BigDecimal productionlossnr;
    private BigDecimal projectrevenue;
    private String username;
    private String operation;
    private Date datestamp;

    private long licensenumberif;
    private BigDecimal sumyrlyprodexpcy;
    private BigDecimal sumyearlysalesvaluecy;
    private BigDecimal fixedassetcostbuildcons;
    private BigDecimal fixedassetcostequipment;
    private BigDecimal yearlyfixedexpense;
    private BigDecimal yearlydepreciation;
    private BigDecimal yearlyvariableexpense1;
    private BigDecimal yearlyvariableexpense2;

    private BigDecimal yearlyvariableexpense3;
    private BigDecimal yearlyvariableexpense4;
    private BigDecimal yearlyvariableexpense5;
    private BigDecimal total;
    private BigDecimal perProductionExpense;
    private BigDecimal SumYearlyProdExpense;


}
