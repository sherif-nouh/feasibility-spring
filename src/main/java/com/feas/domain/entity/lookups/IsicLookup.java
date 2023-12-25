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
 * @Date ٢٢/٠٦/٢٠٢٣
 */
@Entity
@Table(name="ISIC_LOOKUP")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IsicLookup implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ISIC_ID")
    private long isicId;

    @Column(name="ISIC_CODE")
    private long isicCode;

    private String production;

}