package com.feas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FEASBILITY_REJECTION database table.
 * 
 */
@Entity
@Table(name="FEASBILITY_REJECTION")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeasbilityRejection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
	@GeneratedValue(generator = "custom_seq")
	@Column(name="FEASBILITY_REJECTION_ID")
	private long feasbilityRejectionId;

	@Column(name="ECONOMIC_REMARKS")
	private String economicRemarks;

	@Column(name="FEAS_REMARKS")
	private String feasRemarks;

	@Column(name="INSERT_BY")
	private BigDecimal insertBy;

	@Temporal(TemporalType.DATE)
	@Column(name="INSERT_DT")
	private Date insertDt;

	@Column(name="MARKET_REMARKS")
	private String marketRemarks;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DT")
	private Date modifiedDt;

	@Column(name="MODIFY_BY")
	private BigDecimal modifyBy;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="REQUEST_NUMBER_IF")
	private BigDecimal requestNumberIf;

	@Column(name="TECH_REMAKRS")
	private String techRemakrs;





}