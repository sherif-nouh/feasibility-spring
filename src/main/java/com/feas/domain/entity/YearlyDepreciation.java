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
@Table(name="YEARLY_DEPRECIATION")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class YearlyDepreciation implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private YearlyDepreciationPK id;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Column(name="DEP_AIR_COND_CY")
    private BigDecimal depAirCondCy;

    @Column(name="DEP_BUILD_CONST_CY")
    private BigDecimal depBuildConstCy;

    @Column(name="DEP_EQUIP_AFTER_INSTAL_CY")
    private BigDecimal depEquipAfterInstalCy;

    @Column(name="DEP_INT_TRANSP_CY")
    private BigDecimal depIntTranspCy;

    @Column(name="DEP_OF_EXT_TRANSP_CY")
    private BigDecimal depOfExtTranspCy;

    @Column(name="DEP_OF_FUR_FOR_WAHOUSE_CY")
    private BigDecimal depOfFurForWahouseCy;

    @Column(name="DEP_OF_OFF_FUR_CY")
    private BigDecimal depOfOffFurCy;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="OTHER_DEP_CY")
    private BigDecimal otherDepCy;

    @Column(name="PERC_DEP_AIR_COND_CY")
    private BigDecimal percDepAirCondCy;

    @Column(name="PERC_DEP_BUILD_CONST_CY")
    private BigDecimal percDepBuildConstCy;

    @Column(name="PERC_DEP_EXT_TRANSP_CY")
    private BigDecimal percDepExtTranspCy;

    @Column(name="PERC_DEP_INT_TRANSP_CY")
    private BigDecimal percDepIntTranspCy;

    @Column(name="PERC_DEP_OF_FUR_WAHOUSE_CY")
    private BigDecimal percDepOfFurWahouseCy;

    @Column(name="PERC_DEP_OFFICE_FUR_CY")
    private BigDecimal percDepOfficeFurCy;

    @Column(name="PERCDEP_EQUIP_A_INST_CY")
    private BigDecimal percdepEquipAInstCy;

    @Column(name="USER_NAME")
    private String userName;



}
