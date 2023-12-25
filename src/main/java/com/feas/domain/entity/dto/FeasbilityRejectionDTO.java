package com.feas.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ١٤/٠٢/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeasbilityRejectionDTO {
    private long feasbilityRejectionId;

    private String economicRemarks;

    private String feasRemarks;

    private BigDecimal insertBy;

    private Date insertDt;

    private String marketRemarks;

    private Date modifiedDt;

    private BigDecimal modifyBy;

    private String operation;

    private BigDecimal requestNumberIf;

    private String techRemakrs;

}
