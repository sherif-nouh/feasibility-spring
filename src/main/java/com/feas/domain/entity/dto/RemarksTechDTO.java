package com.feas.domain.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٤/٠٩/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RemarksTechDTO {
    private long remarksTechId;

    private BigDecimal insertBy;

    private BigDecimal licenseNumberIf;

    private String operation;

    private BigDecimal projectNumberIf;

    private String remarksProdProcess;

    private String remarksStandSpecify;

    private BigDecimal requestNumberIf;

    private BigDecimal updateBy;


}
