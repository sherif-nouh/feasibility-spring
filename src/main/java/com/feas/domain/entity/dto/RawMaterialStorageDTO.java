package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠٧/٠٢/٢٠٢٣
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RawMaterialStorageDTO {

    private long rawMaterialStorageId;
    private BigDecimal addAreaReqNr;
    private BigDecimal areaReqForStorageNr;
    private Date dateStamp;
    private BigDecimal licenseNumberIf;
    private BigDecimal materialTypeIf;
    private String methodOfStorTx;
    private String noOfUnitsStoredNr;
    private String operation;
    private BigDecimal prodOriginIf;
    private BigDecimal projectNumberIf;
    private BigDecimal proposedStockFk;
    private String qtyReqStoToKpProdGoNr;
    private BigDecimal quantityPerYearNr;
    private BigDecimal rawMatIf;
    private String rawmatReceiveMethodTx;
    private BigDecimal requestNumberIf;
    private BigDecimal serialNumberId;
    private BigDecimal sno;
    private String source;
    private String storPerReqToKpProdGoNr;
    private String storageUnitTx;
    private BigDecimal unitCodeIf;
    private String userName;
}
