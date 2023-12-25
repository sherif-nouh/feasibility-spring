package com.feas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.feas.domain.entity.lookups.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the INDUSTRIAL_PLOT_BUILD_COST database table.
 * 
 */
@Entity
@Table(name="INDUSTRIAL_PLOT_BUILD_COST")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IndustrialPlotBuildCost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
	@GeneratedValue(generator = "custom_seq")
	@Column(name="INDUSTRIAL_PLOT_BUILD_COST_ID")
	private long industrialPlotBuildCostId;

	@Column(name="AREA_AS_EST_PAI_NR")
	private BigDecimal areaAsEstPaiNr;

	@Column(name="AREA_NR")
	private BigDecimal areaNr;

	@Column(name="AREA_NUM")
	private BigDecimal areaNum;

	@Column(name="AREA_REQUESTED")
	private BigDecimal areaRequested;

	@Column(name="BUILD_CODE_IF")
	private BigDecimal buildCodeIf;

	@Column(name="COST_CY")
	private BigDecimal costCy;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="LAND_PREP_EXP_CY")
	private BigDecimal landPrepExpCy;

	@Column(name="LICENSE_NUMBER_IF")
	private BigDecimal licenseNumberIf;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="PAI_REMARKS_TX")
	private String paiRemarksTx;

	@Column(name="PROJECT_NUMBER_IF")
	private BigDecimal projectNumberIf;

	@Column(name="REQUEST_NUMBER_IF")
	private BigDecimal requestNumberIf;

	private BigDecimal sno;

	@Column(name="SQM_CHAR")
	private String sqmChar;

	@Column(name="SUPERV_EXP_PERC")
	private BigDecimal supervExpPerc;

	@Column(name="USER_NAME")
	private String userName;

	@Transient
	private BigDecimal totalArea;
	@Transient
	private BigDecimal cArea;
	@Transient
	private BigDecimal bArea;
	@Transient
	private BigDecimal rawmatarea;
	@Transient
	private BigDecimal rawMatStorage;
	@Transient
	private BigDecimal productStorage;
	@Transient
	private BigDecimal productionArea;
	@Transient
	private BigDecimal sumSqm;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name="BUILD_CODE_IF",insertable = false,updatable = false)
	private Building building;

	@PostLoad
	private void postLoad() {
			this.totalArea = this.costCy.multiply(this.areaNr);
	}

	@PrePersist
	private void createDate(){
		this.dateStamp=new Date();
	}


}