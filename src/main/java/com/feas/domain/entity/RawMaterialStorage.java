package com.feas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.feas.domain.entity.lookups.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the RAW_MATERIAL_STORAGE database table.
 * 
 */
@Entity
@Table(name="RAW_MATERIAL_STORAGE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RawMaterialStorage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
	@GeneratedValue(generator = "custom_seq")
	@Column(name="RAW_MATERIAL_STORAGE_ID")
	private long rawMaterialStorageId;

	@Column(name="ADD_AREA_REQ_NR")
	private BigDecimal addAreaReqNr;

	@Column(name="AREA_REQ_FOR_STORAGE_NR")
	private BigDecimal areaReqForStorageNr;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="LICENSE_NUMBER_IF")
	private BigDecimal licenseNumberIf;

	@Column(name="MATERIAL_TYPE_IF")
	private BigDecimal materialTypeIf;

	@Column(name="METHOD_OF_STOR_TX")
	private String methodOfStorTx;

	@Column(name="NO_OF_UNITS_STORED_NR")
	private String noOfUnitsStoredNr;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="PROD_ORIGIN_IF")
	private BigDecimal prodOriginIf;

	@Column(name="PROJECT_NUMBER_IF")
	private BigDecimal projectNumberIf;

	@Column(name="PROPOSED_STOCK_FK")
	private BigDecimal proposedStockFk;

	@Column(name="QTY_REQ_STO_TO_KP_PROD_GO_NR")
	private String qtyReqStoToKpProdGoNr;

	@Column(name="QUANTITY_PER_YEAR_NR")
	private BigDecimal quantityPerYearNr;

	@Column(name="RAW_MAT_IF")
	private BigDecimal rawMatIf;

	@Column(name="RAWMAT_RECEIVE_METHOD_TX")
	private String rawmatReceiveMethodTx;

	@Column(name="REQUEST_NUMBER_IF")
	private BigDecimal requestNumberIf;

	@Column(name="SERIAL_NUMBER_ID")
	private BigDecimal serialNumberId;

	private BigDecimal sno;

	private String source;

	@Column(name="STOR_PER_REQ_TO_KP_PROD_GO_NR")
	private String storPerReqToKpProdGoNr;

	@Column(name="STORAGE_UNIT_TX")
	private String storageUnitTx;

	@Column(name="UNIT_CODE_IF")
	private BigDecimal unitCodeIf;

	@Column(name="USER_NAME")
	private String userName;
    @Transient
	private String countryTx;
	@Transient
	private String matNameTx;
	@Transient
	private String unitDescTx;
   // @Transient
	/*@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "RAW_MAT_IF", updatable = false,insertable = false)
	private Material material;
	//@Transient
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PROD_ORIGIN_IF",insertable = false,updatable = false)
	private Country country;
	//@Transient
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "UNIT_CODE_IF",updatable = false,insertable = false)
	private Unit unit;*/

}