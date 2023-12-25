package com.feas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FIXED_ASSETS_COST database table.
 * 
 */
@Entity
@Table(name="FIXED_ASSETS_COST")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FixedAssetsCost implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FixedAssetsCostPK id;

	@Column(name="COST_OF_AIR_COND_CY")
	private BigDecimal costOfAirCondCy;

	@Column(name="COST_OF_BUILD_CONST_CY")
	private BigDecimal costOfBuildConstCy;

	@Column(name="COST_OF_EQUIP_CY")
	private BigDecimal costOfEquipCy;

	@Column(name="COST_OF_EXT_TRANSP_VEH_CY")
	private BigDecimal costOfExtTranspVehCy;

	@Column(name="COST_OF_FURN_CY")
	private BigDecimal costOfFurnCy;

	@Column(name="COST_OF_INT_TRANSP_VEH_CY")
	private BigDecimal costOfIntTranspVehCy;

	@Column(name="COST_OF_SPARTS_CY")
	private BigDecimal costOfSpartsCy;

	@Column(name="COST_OF_STORE_PREP_CY")
	private BigDecimal costOfStorePrepCy;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="OTHER_COST_CY")
	private BigDecimal otherCostCy;

	@Column(name="USER_NAME")
	private String userName;

	//bi-directional many-to-one association to GeneralInformation
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROJECT_NUMBER_IF" ,insertable = false,updatable = false)
	private GeneralInformation generalInformation1;

	//bi-directional many-to-one association to GeneralInformation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LICENSE_NUMBER_IF" ,insertable = false,updatable = false)
	private GeneralInformation generalInformation2;*/


}