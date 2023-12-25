package com.feas.domain.entity.dto;

import com.feas.domain.entity.ProjectRevenuePK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ١٣/٠٧/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectRevenueDTO {

    private long projectNumberIf;

    private long requestNumberIf;

    private long licenseNumberIf;

    private String operation;

    private BigDecimal percProdLossCy;

    private BigDecimal productionLossNr;

    private BigDecimal projectRevenue;

    private BigDecimal sumYrlyProdExpCy;

    private String userName;

    private BigDecimal yrlyProdExpCy;

    private BigDecimal yrlySalesValCy;

}
