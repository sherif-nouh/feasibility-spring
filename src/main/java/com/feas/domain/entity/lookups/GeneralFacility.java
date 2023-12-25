package com.feas.domain.entity.lookups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٢/٢٠٢٣
 */
@Entity
@Table(name="GENERAL_FACILITY")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GeneralFacility implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "GEN_FAC_CODE_ID")
    private long genFacCodeId;

    @Column(name = "COST_PER_UNIT_CY")
    private BigDecimal costPerUnitCy;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_STAMP")
    private Date dateStamp;

    @Column(name = "GEN_FAC_CAT_TX")
    private String genFacCatTx;

    @Column(name = "GEN_FAC_DESC_TX")
    private String genFacDescTx;

    @Column(name = "GEN_FAC_TYPE_IF")
    private BigDecimal genFacTypeIf;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "UNIT_CODE_IF")
    private BigDecimal unitCodeIf;

    @Column(name = "USER_NAME")
    private String userName;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="UNIT_CODE_IF",insertable = false,updatable = false)
    private Unit unit;
}