package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ١٤/٠٢/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GeneralInformationDTO {

    private long licenseNumberIf;

    private String action;

    private BigDecimal actionBy;

    private Date actionDt;

    private BigDecimal activeYn;

    private String activity;

    private BigDecimal activityTypeIf;

    private BigDecimal applicantCivilidIf;

    private String applicantName;

    private BigDecimal businessIdNr;

    private BigDecimal comCivilNumber;

    private Date commRegDate;

    private String commercialName;

    private BigDecimal commercialNumber;

    private String companyName;

    private BigDecimal creditFacilityResourcesCy;

    private BigDecimal custodianCivilidNr;

    private Date dateOfBirth;

    private BigDecimal directorExecutiveName;

    private BigDecimal durationCompletionNr;

    private String email;

    private String engName;

    private String extNr;

    private String faxNo;

    private String fileName;

    private Date firstLicenseIssuedDt;

    private BigDecimal grossEstimatedInvestmentNr;

    private Date indRegDt;

    private BigDecimal indRegNr;

    private BigDecimal indType;

    private BigDecimal industrialAreaApprovedNr;

    private BigDecimal industrialAreaRequestedNr;

    private BigDecimal isicCode;

    private BigDecimal legalCatIf;

    private Date licenseCancelledDt;

    private BigDecimal licenseCivilId;

    private BigDecimal licenseCivilIdNo;

    private Date licenseEdt;

    private BigDecimal licenseNumberId;

    private Date licenseSdt;

    private BigDecimal licenseStatusIf;

    private String licenseType;

    private BigDecimal loanFromCommbankCy;

    private BigDecimal loanFromIndbankCy;

    private BigDecimal mobileNo;

    private BigDecimal nationalityNumberIf;

    private BigDecimal numberShiftsNr;

    private BigDecimal oldLicNo;

    private BigDecimal otherLocalPaumentNr;

    private BigDecimal paciCivil;

    private BigDecimal paidUpCapitalNr;

    private BigDecimal percCreditOfresources;

    private BigDecimal percLoanCommbank;

    private BigDecimal percLoanIndbank;

    private String poBoxNr;

    private String postCode;

    private String productionKind;

    private BigDecimal projectNumberId;

    private BigDecimal requestNumberIf;

    private Date startProductionDt;

    private String statusRemarks;

    private String technicalAssistanceFromTx;

    private String telephoneNr;

    private String telephoneNr2;

    private String telephoneNr3;

    private BigDecimal totalActualManpowerNr;

    private BigDecimal totalCapital;

    private BigDecimal totalInvestment;

    private String url;

    private BigDecimal workingDaysYearNr;
}
