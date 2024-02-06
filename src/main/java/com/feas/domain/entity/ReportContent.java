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
@Table(name="REPORT_CONTENT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportContent implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
	@GeneratedValue(generator = "custom_seq")
	@Column(name="REPORT_CONTENT_ID")
	private Long reportContentId;

	@Column(name="NUMBER_AR")
	private String numberAr;

	@Column(name="DETAIL_TX")
	private String detailTx;

	@Column(name="PAGE_NO_TX")
	private String pageNoTx;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="REQUEST_NUMBER_IF")
	private BigDecimal requestNumberIf;

	@Column(name="LICENSE_NUMBER_IF")
	private BigDecimal licenseNumberIf;

	@Column(name="PROJECT_NUMBER_IF")
	private BigDecimal projectNumberIf;

	@Column(name="ORDER_NR")
	private BigDecimal orderNr;







}