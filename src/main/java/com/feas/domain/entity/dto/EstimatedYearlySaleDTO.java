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
 * @Date ٢١/٠٢/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstimatedYearlySaleDTO {
    private long estimatedYearlySalesId;

    private Date dateStamp;

    private BigDecimal endQuantity;

    private BigDecimal endValue;

    private Date finEndDate;

    private Date finStartDate;

    private String operation;

    private BigDecimal productCodeId;

    private String productDescTx;

    private BigDecimal quantityNr;

    private String remarksTx;

    private BigDecimal requestNumberIf;

    private BigDecimal salesQuantity;

    private BigDecimal salesValue;

    private BigDecimal sno;

    private BigDecimal startQuantity;

    private BigDecimal startValue;

    private BigDecimal unitCodeIf;

    private BigDecimal unitPriceCy;

    private String userName;
    private long licenseNumberIf;
    private long projectNumberIf;
    private BigDecimal sumTotalPrice;
}
