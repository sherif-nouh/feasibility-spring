package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٤/١٠/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProjectFinancingResponseDTO {
    private Long projectnumberif;
    private Long requestnumberif;
    private BigDecimal paidupcapcy;

    private BigDecimal loanfromindbankcy;

    private BigDecimal loanfromcommbankcy;
    private BigDecimal creditfacicy;

    private BigDecimal percinterestloanindbnr;

    private BigDecimal percinterestloancombnr;
    private String username;
    private String operation;
    private Long licensenumberif;
    private Long projectfinancingid;
    private BigDecimal fixedassetcostvalue;
    private BigDecimal projectsetupcostvalue;
    private BigDecimal operatingcapitalvalue;

    private BigDecimal totalFinancing;
    private BigDecimal commercialBank;
    private BigDecimal industrialBank;
    private BigDecimal insertOnLoan;


}
