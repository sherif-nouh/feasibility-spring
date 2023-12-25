package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٦/٠٩/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TempRequestDTO {

    private Long requestNumberId;
    private Long subReqNo;
    private Long subSno;
    private String transactionNo;
    private Long licenseNumberIf;
    private Long webReqNo;
    private Long indRegNr;
    private BigDecimal applicantCivilidNr;
    private String firstNameTx;
    private String secondNameTx;
    private String thirdNameTx;
    private String familyNameTx;
    private String purposeReqTx;
    private Double TAmountChargeableCy;
    private String remarksTx;
    private String email;
    private Long daysGiven;
    private String urlAdd;
    private String reason;
    private Long legalEntityNr;
    private String statusNr;
    private String userName;
    private String operation;
    private Long applicantType;
    private String telephoneNo;
    private String extNo;
    private String faxNo;
    private String companyDetail;
    private String ownerName;
    private String applicantDesignation;
    private String poBoxNr;
    private Long projectNumberIf;
    private String beneficiaryTx;
    private Long rentContractIf;
    private Long toLicenseIf;
    private String remarksBydept;
    private String presidentSection;
    private String managerDeptTx;
    private Long toOwnerCivilid;
    private Long commnameChangedYn;
    private Long lostDmgYn;
    private BigDecimal installExp;
    private BigDecimal transpExp;
    private Double percFgArea;
    private String deptRemarks;
    private String renewYn;
    private String transferYn;
    private String cancelYn;
    private String additionYn;
    private String mergeYn;
    private String mixYn;
    private String changeProdYn;
    private String inheritYn;
    private String areaCode;
    private BigDecimal contractNo;
    private BigDecimal insuranceCy;
    private Double appEstimations;
    private Long certificatePlotNo;
    private String presentedToTx;
    private Long additionalArea;

    private Double reqHandlerIf;
    private String bookNoTx;
    private String coverTx;
    private String transferToTx;
    private String productionKind;
    private Long totalCapital;
    private Long mobileNo;
    private Long licenseActivityType;
    private Long transId;

}
