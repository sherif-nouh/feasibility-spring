package com.feas.domain.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢١/٠٣/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class YearlyFixedVariableExpenseDTO implements YearlyFixedVariableExpense{

    private long licenseNumberIf;
    private long  requestnumberif;
    private BigDecimal tyrdepcy;
    private BigDecimal yearlyvariableexpensescost;
    private BigDecimal buildingconstructioncost;
    private BigDecimal buildingmaintenancecost;
    private BigDecimal fixedequipmentcost;
    private BigDecimal yearlyspareequipmentcost;
    private BigDecimal tyrfixedexpcy;
    private BigDecimal annualexpenses;
    private BigDecimal variableexpenses;
    private BigDecimal fixedexpenses;
    private BigDecimal tyrvarexpcy;
    private BigDecimal percdepbuildconstcy;
    private BigDecimal   depbuildconstcy;
    private BigDecimal percdepequipainstcy;
    private BigDecimal   depequipafterinstalcy;
    private BigDecimal percdepaircondcy;
    private BigDecimal  depaircondcy;
    private BigDecimal percdepofficefurcy;
    private BigDecimal  depofofffurcy;
    private BigDecimal percdepoffurwahousecy;
    private BigDecimal  depoffurforwahousecy;
    private BigDecimal percdepexttranspcy;
    private BigDecimal  depofexttranspcy;
    private BigDecimal percdepinttranspcy;

    private BigDecimal depinttranspcy;
    private BigDecimal otherdepcy;
    private String  username;
    private String   operation;
    private BigDecimal building;
    private BigDecimal equipment;
    private BigDecimal aircondition;
    private BigDecimal furniture;
    private BigDecimal store;
    private BigDecimal evehicle;

    private BigDecimal ivehicle;
    public BigDecimal yealrydepreciationvalue;


}
