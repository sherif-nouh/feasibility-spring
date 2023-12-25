package com.feas.domain.entity.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٤/٠٩/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProposedCarrierDTO {

    private long proposedCarrierId;

    private String actualRemarksTx;

    private String approvedRemarksTx;

    private BigDecimal exchangeRateCy;

    private BigDecimal foreignCodeIf;

    private Long licenseNumberIf;

    private BigDecimal manufCtryCodeIf;

    private String operation;

    private Long projectNumberIf;

    private String proposedRemarksBy;

    private BigDecimal quantityActual;

    private BigDecimal quantityApproved;

    private BigDecimal quantityNr;

    private String remarks;

    private String remarksActualBy;

    private String remarksApprovedBy;

    private String remarksProposedBy;

    private Long requestNumberIf;

    private BigDecimal serialNumberId;

    private BigDecimal unitPriceCy;

    private String userName;

    private BigDecimal vehCodeIf;

    private BigDecimal vehType;

    private String vehicalName;


}
