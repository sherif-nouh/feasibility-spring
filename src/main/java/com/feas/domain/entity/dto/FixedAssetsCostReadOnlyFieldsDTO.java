package com.feas.domain.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ١٢/٠٣/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FixedAssetsCostReadOnlyFieldsDTO implements FixedAssetsCostReadOnlyFields{

    private long projectNumberIf;

    private long requestNumberIf;

    private long licenseNumberIf;

    private BigDecimal costOfAirCondCy;

    private BigDecimal costOfBuildConstCy;

    private BigDecimal costOfEquipCy;

    private BigDecimal costOfExtTranspVehCy;

    private BigDecimal costOfFurnCy;

    private BigDecimal costOfIntTranspVehCy;

    private BigDecimal costOfSpartsCy;

    private BigDecimal costofstoreprepcy;

    private BigDecimal otherCostCy;

    private BigDecimal fixedAssetsTotalCost;

    private BigDecimal cbuild;

    private BigDecimal equipmentCost;

    private BigDecimal tvali;

    private BigDecimal tvale;

    private BigDecimal totalCost;

    private String userName;

}
