package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ١٦/٠٧/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class YearlyDepreciationCustomDTO {
   private BigDecimal projectNumberIf;
    private BigDecimal requestNumberIf;
    private BigDecimal percDepBuildConstCy;
    private BigDecimal depBuildConstCy;
    private BigDecimal percdepEquipAInstCy;
    private BigDecimal depEquipAfterInstalCy;
    private BigDecimal percDepAirCondCy;
    private BigDecimal depAirCondCy;
    private BigDecimal percDepOfficeFurCy;
    private BigDecimal depOfOffFurCy;
    private BigDecimal percDepOfFurWahouseCy;
    private BigDecimal depOfFurForWahouseCy;
    private BigDecimal percDepExtTranspCy;
    private BigDecimal depOfExtTranspCy;
    private BigDecimal percDepIntTranspCy;
    private BigDecimal depIntTranspCy;
    private BigDecimal otherDepCy;
    private String userName;
    private String operation;
    private BigDecimal licenseNumberIf;
    private BigDecimal yealryDepreciationValue;
    private BigDecimal building;
    private BigDecimal equipment;
    private BigDecimal airCondition;
    private BigDecimal furniture;
    private BigDecimal store;
    private BigDecimal eVehicle;
    private BigDecimal iVehicle;


}
