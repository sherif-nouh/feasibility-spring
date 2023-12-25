package com.feas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٥/٠٣/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OperatingCapitalId implements Serializable {

    private BigDecimal licenseNumberIf;
    private BigDecimal projectNumberIf;

    private BigDecimal requestNumberIf;

}
