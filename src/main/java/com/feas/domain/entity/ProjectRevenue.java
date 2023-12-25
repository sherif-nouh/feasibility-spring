package com.feas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@Entity
@Table(name="PROJECT_REVENUE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectRevenue implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ProjectRevenuePK id;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="PERC_PROD_LOSS_CY")
    private BigDecimal percProdLossCy;

    @Column(name="PRODUCTION_LOSS_NR")
    private BigDecimal productionLossNr;

    @Column(name="PROJECT_REVENUE")
    private BigDecimal projectRevenue;

    @Column(name="SUM_YRLY_PROD_EXP_CY")
    private BigDecimal sumYrlyProdExpCy;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="YRLY_PROD_EXP_CY")
    private BigDecimal yrlyProdExpCy;

    @Column(name="YRLY_SALES_VAL_CY")
    private BigDecimal yrlySalesValCy;


}