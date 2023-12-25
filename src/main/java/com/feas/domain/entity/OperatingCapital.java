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
@Table(name="OPERATING_CAPITAL")
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(OperatingCapitalId.class)
public class OperatingCapital implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="COST_OF_SALS_2MONTHS_CY")
    private BigDecimal costOfSals2monthsCy;

    @Column(name="COST_OF_STO_R_MAT_3MONTHS_CY")
    private BigDecimal costOfStoRMat3monthsCy;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Id
    @Column(name="LICENSE_NUMBER_IF")
    private BigDecimal licenseNumberIf;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="OTHER_COSTS_CY")
    private BigDecimal otherCostsCy;
    @Id
    @Column(name="PROJECT_NUMBER_IF")
    private BigDecimal projectNumberIf;
    @Id

    @Column(name="REQUEST_NUMBER_IF")
    private BigDecimal requestNumberIf;

    @Column(name="USER_NAME")
    private String userName;


}