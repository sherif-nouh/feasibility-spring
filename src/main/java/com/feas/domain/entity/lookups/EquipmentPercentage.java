package com.feas.domain.entity.lookups;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Sherif Nouh
 * @Date ٢٨/٠٥/٢٠٢٣
 */
@Entity
@Table(name="EQUIPMENT_PERCENTAGES")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentPercentage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PERC_ID")
    private long percId;

    @Column(name = "PERC_NAME")
    private String percName;
}