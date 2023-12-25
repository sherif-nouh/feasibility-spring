package com.feas.domain.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٤/٠٩/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IndustrialPlotBuildCostDTO {
    private long industrialPlotBuildCostId;

    private BigDecimal areaAsEstPaiNr;

    private BigDecimal areaNr;

    private BigDecimal areaNum;

    private BigDecimal areaRequested;

    private BigDecimal buildCodeIf;

    private BigDecimal costCy;

    private BigDecimal landPrepExpCy;

    private BigDecimal licenseNumberIf;

    private String operation;

    private String paiRemarksTx;

    private BigDecimal projectNumberIf;

    private BigDecimal requestNumberIf;

    private BigDecimal sno;

    private String sqmChar;

    private BigDecimal supervExpPerc;

    private String userName;

    private BigDecimal totalArea;
    private BigDecimal cArea;

    private BigDecimal bArea;
    private BigDecimal rawmatarea;
    private BigDecimal rawMatStorage;
    private BigDecimal productStorage;
    private BigDecimal productionArea;
    private BigDecimal sumSqm;

}
