package com.feas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GENERAL_INFORMATION database table.
 * 
 */
@Entity
@Table(name="GENERAL_INFORMATION")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GeneralInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
	@GeneratedValue(generator = "custom_seq")
	@Column(name="LICENSE_NUMBER_IF")
	private long licenseNumberIf;

	@Column(name="ACTION")
	private String action;

	@Column(name="ACTION_BY")
	private BigDecimal actionBy;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTION_DT")
	private Date actionDt;

	@Column(name="ACTIVE_YN")
	private BigDecimal activeYn;

	private String activity;

	@Column(name="ACTIVITY_TYPE_IF")
	private BigDecimal activityTypeIf;

	@Column(name="APPLICANT_CIVILID_IF")
	private BigDecimal applicantCivilidIf;

	@Column(name="APPLICANT_NAME")
	private String applicantName;

	@Column(name="BUSINESS_ID_NR")
	private BigDecimal businessIdNr;

	@Column(name="COM_CIVIL_NUMBER")
	private BigDecimal comCivilNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="COMM_REG_DATE")
	private Date commRegDate;

	@Column(name="COMMERCIAL_NAME")
	private String commercialName;

	@Column(name="COMMERCIAL_NUMBER")
	private BigDecimal commercialNumber;

	@Column(name="COMPANY_NAME")
	private String companyName;

	@Column(name="CREDIT_FACILITY_RESOURCES_CY")
	private BigDecimal creditFacilityResourcesCy;

	@Column(name="CUSTODIAN_CIVILID_NR")
	private BigDecimal custodianCivilidNr;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name="DIRECTOR_EXECUTIVE_NAME")
	private BigDecimal directorExecutiveName;

	@Column(name="DURATION_COMPLETION_NR")
	private BigDecimal durationCompletionNr;

	private String email;

	@Column(name="ENG_NAME")
	private String engName;

	@Column(name="EXT_NR")
	private String extNr;

	@Column(name="FAX_NO")
	private String faxNo;

	@Column(name="FILE_NAME")
	private String fileName;

	@Temporal(TemporalType.DATE)
	@Column(name="FIRST_LICENSE_ISSUED_DT")
	private Date firstLicenseIssuedDt;

	@Column(name="GROSS_ESTIMATED_INVESTMENT_NR")
	private BigDecimal grossEstimatedInvestmentNr;

	@Temporal(TemporalType.DATE)
	@Column(name="IND_REG_DT")
	private Date indRegDt;

	@Column(name="IND_REG_NR")
	private BigDecimal indRegNr;

	@Column(name="IND_TYPE")
	private BigDecimal indType;

	@Column(name="INDUSTRIAL_AREA_APPROVED_NR")
	private BigDecimal industrialAreaApprovedNr;

	@Column(name="INDUSTRIAL_AREA_REQUESTED_NR")
	private BigDecimal industrialAreaRequestedNr;

	@Column(name="ISIC_CODE")
	private BigDecimal isicCode;

	@Column(name="LEGAL_CAT_IF")
	private BigDecimal legalCatIf;

	@Temporal(TemporalType.DATE)
	@Column(name="LICENSE_CANCELLED_DT")
	private Date licenseCancelledDt;

	@Column(name="LICENSE_CIVIL_ID")
	private BigDecimal licenseCivilId;

	@Column(name="LICENSE_CIVIL_ID_NO")
	private BigDecimal licenseCivilIdNo;

	@Temporal(TemporalType.DATE)
	@Column(name="LICENSE_EDT")
	private Date licenseEdt;

	@Column(name="LICENSE_NUMBER_ID")
	private BigDecimal licenseNumberId;

	@Temporal(TemporalType.DATE)
	@Column(name="LICENSE_SDT")
	private Date licenseSdt;

	@Column(name="LICENSE_STATUS_IF")
	private BigDecimal licenseStatusIf;

	@Column(name="LICENSE_TYPE")
	private String licenseType;

	@Column(name="LOAN_FROM_COMMBANK_CY")
	private BigDecimal loanFromCommbankCy;

	@Column(name="LOAN_FROM_INDBANK_CY")
	private BigDecimal loanFromIndbankCy;

	@Column(name="MOBILE_NO")
	private BigDecimal mobileNo;

	@Column(name="NATIONALITY_NUMBER_IF")
	private BigDecimal nationalityNumberIf;

	@Column(name="NUMBER_SHIFTS_NR")
	private BigDecimal numberShiftsNr;

	@Column(name="OLD_LIC_NO")
	private BigDecimal oldLicNo;

	@Column(name="OTHER_LOCAL_PAUMENT_NR")
	private BigDecimal otherLocalPaumentNr;

	@Column(name="PACI_CIVIL")
	private BigDecimal paciCivil;

	@Column(name="PAID_UP_CAPITAL_NR")
	private BigDecimal paidUpCapitalNr;

	@Column(name="PERC_CREDIT_OFRESOURCES")
	private BigDecimal percCreditOfresources;

	@Column(name="PERC_LOAN_COMMBANK")
	private BigDecimal percLoanCommbank;

	@Column(name="PERC_LOAN_INDBANK")
	private BigDecimal percLoanIndbank;

	@Column(name="PO_BOX_NR")
	private String poBoxNr;

	@Column(name="POST_CODE")
	private String postCode;

	@Column(name="PRODUCTION_KIND")
	private String productionKind;

	@Column(name="PROJECT_NUMBER_ID")
	private BigDecimal projectNumberId;

	@Column(name="REQUEST_NUMBER_IF")
	private BigDecimal requestNumberIf;

	@Temporal(TemporalType.DATE)
	@Column(name="START_PRODUCTION_DT")
	private Date startProductionDt;

	@Column(name="STATUS_REMARKS")
	private String statusRemarks;

	@Column(name="TECHNICAL_ASSISTANCE_FROM_TX")
	private String technicalAssistanceFromTx;

	@Column(name="TELEPHONE_NR")
	private String telephoneNr;

	@Column(name="TELEPHONE_NR2")
	private String telephoneNr2;

	@Column(name="TELEPHONE_NR3")
	private String telephoneNr3;

	@Column(name="TOTAL_ACTUAL_MANPOWER_NR")
	private BigDecimal totalActualManpowerNr;

	@Column(name="TOTAL_CAPITAL")
	private BigDecimal totalCapital;

	@Column(name="TOTAL_INVESTMENT")
	private BigDecimal totalInvestment;

	private String url;

	@Column(name="WORKING_DAYS_YEAR_NR")
	private BigDecimal workingDaysYearNr;

	//bi-directional many-to-one association to BreakevenPoint

	//bi-directional many-to-one association to BreakevenPoint


	//bi-directional many-to-one association to EstimatedYearlySale
	/*@OneToMany(mappedBy="generalInformation1")
	private List<EstimatedYearlySale> estimatedYearlySales1;*/

	//bi-directional many-to-one association to EstimatedYearlySale
	/*@OneToMany(mappedBy="generalInformation2")
	private List<EstimatedYearlySale> estimatedYearlySales2;
*/
	//bi-directional many-to-one association to FeasbilityRejection
	/*@OneToMany(mappedBy="generalInformation1")
	private List<FeasbilityRejection> feasbilityRejections1;
*/
	//bi-directional many-to-one association to FeasbilityRejection


	//bi-directional many-to-one association to FixedAssetsCost
/*	@OneToMany(mappedBy="generalInformation1")
	private List<FixedAssetsCost> fixedAssetsCosts1;

	//bi-directional many-to-one association to FixedAssetsCost
	@OneToMany(mappedBy="generalInformation2")
	private List<FixedAssetsCost> fixedAssetsCosts2;*/

	//bi-directional many-to-one association to ProposedGeneralFacility

	//bi-directional many-to-one ass
	// ociation to ProposedManpower
	/*@JsonManagedReference
	@OneToMany(mappedBy="generalInformation1")
	private List<ProposedManpower> proposedManpowers1;*/

	//bi-directional many-to-one association to ProposedManpower
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany
	@JoinColumn(name="LICENSE_NUMBER_IF" ,insertable = false,updatable = false)
	private List<IsicLicenseProduction> isicLicenseProductions;

}