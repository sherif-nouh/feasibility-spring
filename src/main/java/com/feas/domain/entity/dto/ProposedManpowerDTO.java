package com.feas.domain.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProposedManpowerDTO {
    private long proposedManpowerId;
    private Date actualDate;
    private String actualRemarksBy;
    private String actualRemarksTx;
    private Date approvedDate;
    private String approvedRemarksBy;
    private String approvedRemarksTx;
    private BigDecimal checked;
    private BigDecimal manpCat;
    private BigDecimal manpType;
    private BigDecimal manpowerCodeIf;
    private BigDecimal manpowerNationalityIf;
    private BigDecimal monthlySalCy;
    private BigDecimal noOfEmpNr;
    private BigDecimal noOfEmployeePai;
    private BigDecimal noOfFMale;
    private BigDecimal noOfMale;
    private String operation;
    private String proposedRemarksBy;
    private String proposedRemarksTx;
    private BigDecimal quantityActual;
    private BigDecimal quantityApproved;
    private BigDecimal requestNumberIf;
    private BigDecimal sno;
    private BigDecimal tYearlySalCy;
    private String userName;

    private BigDecimal licenseNumberIf;
    private BigDecimal projectNumberIf;
    private Date dateStamp;

}
