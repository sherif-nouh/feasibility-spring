package com.feas.domain.entity.dto;

import com.feas.domain.entity.ProposedGeneralFacility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠٥/٠٢/٢٠٢٣
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProposedGeneralFacilityDTO  {

    private long proposedGeneralFacilityId;

    private String actualRemarksBy;

    private String actualRemarksTx;

    private String approvedRemarksBy;

    private String approvedRemarksTx;

    private BigDecimal dataMove;

    private BigDecimal genFacCodeIf;

    private String operation;

    private String proposedRemarksBy;

    private String proposedRemarksTx;

    private BigDecimal quantityActual;

    private BigDecimal quantityApproved;

    private BigDecimal quantityNr;

    private BigDecimal requestNumberIf;

    private BigDecimal sno;

    private BigDecimal totalValueCy;

    private BigDecimal unitCostCy;

    private String userName;

    private Long projectNumberIf;
    private Long licenseNumberIf;

}
