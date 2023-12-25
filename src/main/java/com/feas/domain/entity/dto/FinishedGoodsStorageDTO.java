package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠٩/٠٢/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FinishedGoodsStorageDTO {
    private long finishedGoodsStorageId;
    private BigDecimal areaForStorageNr;
    private Date dateStamp;
    private String dimMehtodTx;
    private String finishedReceiveMethodTx;
    private BigDecimal licenseNumberIf;
    private BigDecimal manufOriginIf;
    private String methodOfStorage;
    private String operation;
    private BigDecimal percAddAreaNr;
    private String periodForStorNr;
    private BigDecimal productCodeUpcIf;
    private BigDecimal projectNumberIf;
    private String qtyOfStorForPeriodNr;
    private BigDecimal quantityPerYearNr;
    private BigDecimal requestNumberIf;
    private BigDecimal roomNr;
    private BigDecimal serialNumberId;
    private BigDecimal sno;
    private String storageMethodTx;
    private BigDecimal unitCodeIf;
    private String unitOfPeriodTx;
    private String unitsStoredNr;
    private String userName;
}
