package com.feas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.feas.domain.entity.lookups.GeneralFacility;
import com.feas.domain.entity.lookups.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PROPOSED_GENERAL_FACILITY database table.
 * 
 */
@Entity
@Table(name="PROPOSED_GENERAL_FACILITY")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProposedGeneralFacility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
	@GeneratedValue(generator = "custom_seq")
	@Column(name="PROPOSED_GENERAL_FACILITY_ID")
	private long proposedGeneralFacilityId;

	@Column(name="ACTUAL_REMARKS_BY")
	private String actualRemarksBy;

	@Column(name="ACTUAL_REMARKS_TX")
	private String actualRemarksTx;

	@Column(name="APPROVED_REMARKS_BY")
	private String approvedRemarksBy;

	@Column(name="APPROVED_REMARKS_TX")
	private String approvedRemarksTx;

	@Column(name="DATA_MOVE")
	private BigDecimal dataMove;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="GEN_FAC_CODE_IF")
	private BigDecimal genFacCodeIf;

	@Column(name="OPERATION")
	private String operation;

	@Temporal(TemporalType.DATE)
	@Column(name="PROP_INSTAL_DATE_DT")
	private Date propInstalDateDt;

	@Column(name="PROPOSED_REMARKS_BY")
	private String proposedRemarksBy;

	@Column(name="PROPOSED_REMARKS_TX")
	private String proposedRemarksTx;

	@Column(name="QUANTITY_ACTUAL")
	private BigDecimal quantityActual;

	@Column(name="QUANTITY_APPROVED")
	private BigDecimal quantityApproved;

	@Column(name="QUANTITY_NR")
	private BigDecimal quantityNr;

	@Column(name="REQUEST_NUMBER_IF")
	private BigDecimal requestNumberIf;

	private BigDecimal sno;

	@Column(name="TOTAL_VALUE_CY")
	private BigDecimal totalValueCy;

	@Column(name="UNIT_COST_CY")
	private BigDecimal unitCostCy;

	@Column(name="USER_NAME")
	private String userName;
	@Column(name="LICENSE_NUMBER_IF")
	private Long licenseNumberIf;
	@Column(name="PROJECT_NUMBER_IF")
	private Long projectNumberIf;
	@Transient
	private BigDecimal totalValue;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name="GEN_FAC_CODE_IF",insertable = false,updatable = false)
	private GeneralFacility generalFacility;

	/*@PostLoad
	private void postLoad() {
		if(this.unitCostCy != null) {
			this.totalValue = this.quantityNr.multiply(unitCostCy == null ? new BigDecimal(0) : this.unitCostCy.divide(new BigDecimal(1000)));
		}
	}*/
}