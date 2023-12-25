package com.feas.domain.entity.lookups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "TEMP_REQUEST")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TempRequest {
    @Id
    @Column
    private Long requestNumberId;
    @Column
    private Long subReqNo;
    @Column
    private Long subSno;
    @Column
    private String transactionNo;
    @Column
    private Long licenseNumberIf;
    @Column
    private Long webReqNo;
    @Column
    private Date requestDt;
    @Column
    private Long indRegNr;
    @Column
    private BigDecimal applicantCivilidNr;
    @Column
    private String firstNameTx;
    @Column
    private String secondNameTx;
    @Column
    private String thirdNameTx;
    @Column
    private String familyNameTx;
    @Column
    private String purposeReqTx;
    @Column(name = "T_AMOUNT_CHARGEABLE_CY")
    private Double TAmountChargeableCy;
    @Column
    private String remarksTx;
    @Column
    private String email;
    @Column
    private Long daysGiven;
    @Column
    private String urlAdd;
    @Column
    private String reason;
    @Column
    private Long legalEntityNr;
    @Column
    private String statusNr;
    @Column
    private String userName;
    @Column
    private String operation;
    @Column
    private Date dateStamp;
    @Column
    private Long applicantType;
    @Column
    private String telephoneNo;
    @Column
    private String extNo;
    @Column
    private String faxNo;
    @Column
    private String companyDetail;
    @Column
    private String ownerName;
    @Column
    private String applicantDesignation;
    @Column
    private String poBoxNr;
    @Column
    private Long projectNumberIf;
    @Column
    private String beneficiaryTx;
    @Column
    private Long rentContractIf;
    @Column
    private Long toLicenseIf;
    @Column
    private Date newspaperDt;
    @Column
    private String remarksBydept;
    @Column
    private String presidentSection;
    @Column
    private String managerDeptTx;
    @Column
    private Long toOwnerCivilid;
    @Column
    private Long commnameChangedYn;
    @Column
    private Long lostDmgYn;
    @Column
    private BigDecimal installExp;
    @Column
    private BigDecimal transpExp;
    @Column
    private Double percFgArea;
    @Column
    private String deptRemarks;
    @Column
    private String renewYn;
    @Column
    private String transferYn;
    @Column
    private String cancelYn;
    @Column
    private String additionYn;
    @Column
    private String mergeYn;
    @Column
    private String mixYn;
    @Column
    private String changeProdYn;
    @Column
    private String inheritYn;
    @Column
    private String areaCode;
    @Column
    private BigDecimal contractNo;
    @Column
    private BigDecimal insuranceCy;
    @Column
    private Double appEstimations;
    @Column
    private Long certificatePlotNo;
    @Column
    private String presentedToTx;
    @Column
    private Long additionalArea;
    @Column
    private Double reqHandlerIf;
    @Column
    private String bookNoTx;
    @Column
    private String coverTx;
    @Column
    private Date bookDt;
    @Column
    private String transferToTx;
    @Column
    private String productionKind;
    @Column
    private Date dateOfBirth;
    @Column
    private Long totalCapital;
    @Column
    private Long mobileNo;
    @Column
    private Long licenseActivityType;
    @Column
    private Long transId;


}
