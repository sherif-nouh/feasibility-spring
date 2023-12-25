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
@Table(name="PROJECT_SETUP_COST")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectSetupCost implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="PROJECT_SETUP_COST_ID")
    private long projectSetupCostId;

    @Column(name="COST_OF_MARKT_PROM_CY")
    private BigDecimal costOfMarktPromCy;

    @Column(name="COST_OF_STD_TECH_DOC_CY")
    private BigDecimal costOfStdTechDocCy;

    @Column(name="COST_OF_STRT_PROD_PRE_OP_CY")
    private BigDecimal costOfStrtProdPreOpCy;

    @Column(name="COST_OF_TRL_CONSL_CY")
    private BigDecimal costOfTrlConslCy;

    @Column(name="COST_OF_TRNG_CY")
    private BigDecimal costOfTrngCy;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Column(name="LICENSE_NUMBER_IF")
    private BigDecimal licenseNumberIf;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="OTHERS_COST_CY")
    private BigDecimal othersCostCy;

    @Column(name="PROJECT_NUMBER_IF")
    private BigDecimal projectNumberIf;

    @Column(name="REQUEST_NUMBER_IF")
    private BigDecimal requestNumberIf;

    @Column(name="USER_NAME")
    private String userName;
    @Transient
    private BigDecimal projectSetupCost;


}