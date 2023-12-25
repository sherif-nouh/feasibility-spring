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
 * @Date ٣١/٠٥/٢٠٢٣
 */
@Entity
@Table(name="VEHICAL_TYPE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicalType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="VEH_TYPE_ID")
    private long vehTypeId;

    @Column(name="VEH_TYPE_DESC")
    private String vehTypeDesc;
}
