package com.feas.domain.entity.dto;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ١٣/٠٣/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OperatingCapitalROVDTO implements OperatingCapitalROV{

    private BigDecimal costOfSals2MonthsCy;
    private BigDecimal costOfStoRMat3MonthsCy;

    private BigDecimal fixAssetCostCY;

    private BigDecimal projectSetupCostCY;


    private BigDecimal operatingCapitalTotal;

    private BigDecimal totalCapitalization;

}
