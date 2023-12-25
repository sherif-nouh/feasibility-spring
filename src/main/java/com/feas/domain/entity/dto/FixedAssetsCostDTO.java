package com.feas.domain.entity.dto;

import com.feas.domain.entity.FixedAssetsCostPK;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
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
public class FixedAssetsCostDTO {

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

    private BigDecimal costOfStorePrepCy;

    private Date dateStamp;

    private String operation;

    private BigDecimal otherCostCy;

    private String userName;
}
