package com.feas.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FEASBILITY_REJECTION database table.
 * 
 */
@Entity
@Table(name="INTRODUCTION")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Introduction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
	@GeneratedValue(generator = "custom_seq")
	@Column(name="INTRODUCTION_ID")
	private long introductionId;

	@Column(name="REMARKS")
	private String remarks;

	@Column(name="REMARKS_BY")
	private String remarksBy;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="REQUEST_NUMBER_IF")
	private BigDecimal requestNumberIf;

	@Column(name="PROJECT_NUMBER_IF")
	private BigDecimal projectNumberIf;

	@Column(name="LICENSE_NUMBER_IF")
	private BigDecimal licenseNumberIf;







}