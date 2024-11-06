package com.feas.domain.entity;

import java.io.Serializable;

import com.feas.domain.entity.lookups.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PROPOSED_PROJECT_EQUIPMENT database table.
 * 
 */
@Entity
@Table(name="PROPOSED_PROJECT_EQUIPMENT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProposedProjectEquipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
	@GeneratedValue(generator = "custom_seq")
	@Column(name="PROPOSED_PROJ_EQUIP_ID")
	private long proposedProjEquipId;

	@Column(name="AFTREPROD_CAP_PER_8H")
	private BigDecimal aftreprodCapPer8h;

	@Column(name="APPROVE_YN_32")
	private BigDecimal approveYn32;

	@Column(name="APPROVE_YN_34")
	private BigDecimal approveYn34;

	@Column(name="BANK_APPROVAL")
	private BigDecimal bankApproval;

	private BigDecimal checked;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_DT")
	private Date dateDt;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="EFFICIANCY_NR")
	private Long efficiancyNr;

	@Column(name="EQUIP_CODE_IF")
	private Long equipCodeIf;

	@Column(name="EQUIP_NUMBER")
	private BigDecimal equipNumber;

	@Column(name="EQUIP_PERC_IF")
	private Long equipPercIf;

	@Column(name="EQUIPMENT_CAT_IF")
	private Long equipmentCatIf;

	@Column(name="EQUIPMENT_TYPE_IF")
	private Long equipmentTypeIf;

	@Column(name="EXCHANGE_RATE_CY")
	private BigDecimal exchangeRateCy;

	@Column(name="EXIST_YN")
	private String existYn;

	@Column(name="FOREIGN_CODE_IF")
	private Long foreignCodeIf;

	@Column(name="INSTALL_PERC_NR")
	private BigDecimal installPercNr;

	@Column(name="LICENSE_NUMBER_IF")
	private Long licenseNumberIf;

	@Column(name="MANUF_CTRY_CODE_IF")
	private Long manufCtryCodeIf;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="PROD_CAP_PER_8H_NR")
	private BigDecimal prodCapPer8hNr;

	@Column(name="PRODUCTION_DESC")
	private String productionDesc;

	@Column(name="PROJECT_NUMBER_IF")
	private Long projectNumberIf;

	@Column(name="QUANTITY_ACTUAL")
	private BigDecimal quantityActual;

	@Column(name="QUANTITY_ACTUAL_NR")
	private BigDecimal quantityActualNr;

	@Column(name="QUANTITY_APPROVED_NR")
	private BigDecimal quantityApprovedNr;

	@Column(name="QUANTITY_NR")
	private BigDecimal quantityNr;

	@Column(name="RELEASE_REMARKS")
	private String releaseRemarks;

	@Column(name="RELEASE_YN")
	private String releaseYn;

	private String remarks;

	@Column(name="REMARKS_ACTUAL_TX")
	private String remarksActualTx;

	@Column(name="REMARKS_APPROVED_TX")
	private String remarksApprovedTx;

	@Column(name="REMARKS_BY_ACTUAL_TX")
	private String remarksByActualTx;

	@Column(name="REMARKS_BY_APPROVED_TX")
	private String remarksByApprovedTx;

	@Column(name="REMARKS_BY_PROP_TX")
	private String remarksByPropTx;

	@Column(name="REMARKS_PROPOSED_TX")
	private String remarksProposedTx;

	@Column(name="REQUEST_NUMBER_IF")
	private Long requestNumberIf;

	@Column(name="SERIAL_NUMBER_ID")
	private Long serialNumberId;

	@Column(name="SNO_S")
	private Long snoS;

	@Column(name="TOTAL_PRICE")
	private BigDecimal totalPrice;

	@Column(name="TRANS_PEREC_NR")
	private BigDecimal transPerecNr;

	@Column(name="UNIT_PRICE_CY")
	private BigDecimal unitPriceCy;

	@Column(name="USER_NAME")
	private String userName;
    @Transient
	private BigDecimal totalValue;
	@Transient
	private BigDecimal TotalFob;
	@Transient
	private BigDecimal totalInstall;
	@Transient
	private BigDecimal totalTransportation;
	@Transient
	private BigDecimal cif;
	@Transient
	private BigDecimal GrandTotal;
	@Transient
	private BigDecimal totalFis;

	@Transient
	private BigDecimal localEquip;

	@Transient
	private String notesTx;
	@PrePersist
	private void onCreate() {
		dateStamp = new Date();
		operation="I";
	}

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "EQUIPMENT_TYPE_IF", insertable = false,updatable = false)
    private EquipmentType equipmentType;
	 
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "EQUIP_CODE_IF", insertable = false,updatable = false)
    private Product product;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "EQUIPMENT_CAT_IF", insertable = false,updatable = false)
    private EquipCategory equipCategory;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "MANUF_CTRY_CODE_IF", insertable = false,updatable = false)
    private Country country;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "EQUIP_CODE_IF", insertable = false,updatable = false)
    private EquipmentCode equipmentCode;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "EQUIP_PERC_IF", insertable = false,updatable = false)
	private EquipmentPercentage equipmentPercentage;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "FOREIGN_CODE_IF", insertable = false,updatable = false)
	private ForeignCurrency foreignCurrency;
}