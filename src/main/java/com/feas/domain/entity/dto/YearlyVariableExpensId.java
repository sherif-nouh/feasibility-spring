package com.feas.domain.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Sherif Nouh
 * @Date ١٩/٠٣/٢٠٢٣
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class YearlyVariableExpensId implements Serializable {


    private long projectNumberIf;

    private long requestNumberIf;


    private long licenseNumberIf;


}
