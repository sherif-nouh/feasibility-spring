package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٥/١٠/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ValAddedNiResponseDTO implements ValAddedNiResponse{

     private Long econStudyNumberIf;
     private Long projectCharges;
     private BigDecimal workerRemuneration;
    private BigDecimal auditingAccounts;
    private BigDecimal buildingTools;
    private BigDecimal publicityAdv;
    private BigDecimal vehInsurCy;
    private BigDecimal remigrations;
    private Long licenseNumberIf;
    private Long requestNumberIf;
    private BigDecimal operation;
    private BigDecimal insertBy;
    private BigDecimal modifyBy;
    private BigDecimal totalvalueadded;
    private BigDecimal interestonloan;
    private BigDecimal royalties;
    private BigDecimal sumprojectprofit;


}
