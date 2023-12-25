package com.feas.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.feas.domain.config.CheckUtils;
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
 * The persistent class for the PROPOSED_MANPOWER database table.
 * 
 */
@Entity
@Table(name="PROPOSED_MANPOWER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProposedManpower implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
	@GeneratedValue(generator = "custom_seq")
	@Column(name = "PROPOSED_MANPOWER_ID")
	private long proposedManpowerId;

	@Temporal(TemporalType.DATE)
	@Column(name = "ACTUAL_DATE")
	private Date actualDate;

	@Column(name = "ACTUAL_REMARKS_BY")
	private String actualRemarksBy;

	@Column(name = "ACTUAL_REMARKS_TX")
	private String actualRemarksTx;

	@Temporal(TemporalType.DATE)
	@Column(name = "APPROVED_DATE")
	private Date approvedDate;

	@Column(name = "APPROVED_REMARKS_BY")
	private String approvedRemarksBy;

	@Column(name = "APPROVED_REMARKS_TX")
	private String approvedRemarksTx;

	private BigDecimal checked;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_STAMP")
	private Date dateStamp;

	@Column(name = "MANP_CAT")
	private BigDecimal manpCat;

	@Column(name = "MANP_TYPE")
	private BigDecimal manpType;

	@Column(name = "MANPOWER_CODE_IF")
	private BigDecimal manpowerCodeIf;

	@Column(name = "MANPOWER_NATIONALITY_IF")
	private BigDecimal manpowerNationalityIf;

	@Column(name = "MONTHLY_SAL_CY")
	private BigDecimal monthlySalCy;

	@Column(name = "NO_OF_EMP_NR")
	private BigDecimal noOfEmpNr;

	@Column(name = "NO_OF_EMPLOYEE_PAI")
	private BigDecimal noOfEmployeePai;

	@Column(name = "NO_OF_F_MALE")
	private BigDecimal noOfFMale;

	@Column(name = "NO_OF_MALE")
	private BigDecimal noOfMale;

	@Column(name = "OPERATION")
	private String operation;

	@Column(name = "PROPOSED_REMARKS_BY")
	private String proposedRemarksBy;

	@Column(name = "PROPOSED_REMARKS_TX")
	private String proposedRemarksTx;

	@Column(name = "QUANTITY_ACTUAL")
	private BigDecimal quantityActual;

	@Column(name = "QUANTITY_APPROVED")
	private BigDecimal quantityApproved;

	@Column(name = "REQUEST_NUMBER_IF")
	private BigDecimal requestNumberIf;

	private BigDecimal sno;

	@Column(name = "T_YEARLY_SAL_CY")
	private BigDecimal tYearlySalCy;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name="LICENSE_NUMBER_IF")
	private BigDecimal licenseNumberIf;
	@Column(name="PROJECT_NUMBER_IF")
	private BigDecimal projectNumberIf;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name="MANP_CAT",insertable = false,updatable = false)
	private ManpowerCat manpowerCat;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name="MANP_TYPE",insertable = false,updatable = false)
	private ManpowerType manpowerType;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name="MANPOWER_NATIONALITY_IF",insertable = false,updatable = false)
	private ManpowerNationality manpowerNationality;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MANPOWER_CODE_IF", insertable = false, updatable = false)
	private Manpower manpower;

	@PrePersist
	private void onCreate() {
		dateStamp = new Date();


		this.noOfFMale= CheckUtils.isNullOrZero(this.noOfFMale)?new BigDecimal(0):this.noOfFMale;
				this.noOfMale=CheckUtils.isNullOrZero(this.noOfMale)?new BigDecimal(0):this.noOfMale;
						this.monthlySalCy=CheckUtils.isNullOrZero(this.monthlySalCy)?new BigDecimal(0):this.monthlySalCy;
		this.tYearlySalCy=this.monthlySalCy.multiply(this.noOfMale.add(this.noOfFMale)).multiply(new BigDecimal(12));
	}
	@PreUpdate
	private void onUpdate(){

		this.noOfFMale= CheckUtils.isNullOrZero(this.noOfFMale)?new BigDecimal(0):this.noOfFMale;
		this.noOfMale=CheckUtils.isNullOrZero(this.noOfMale)?new BigDecimal(0):this.noOfMale;
		this.monthlySalCy=CheckUtils.isNullOrZero(this.monthlySalCy)?new BigDecimal(0):this.monthlySalCy;
		this.tYearlySalCy=this.monthlySalCy.multiply(this.noOfMale.add(this.noOfFMale)).multiply(new BigDecimal(12));
	}


}