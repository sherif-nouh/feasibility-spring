package com.feas.domain.entity.lookups;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٧/٢٠٢٣
 */
@Entity
@Table(name="MANPOWER_NATIONALITY")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ManpowerNationality implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="MANPOWER_NDESC")
    private String manpowerNdesc;

    @Id
    @Column(name="MANPOWER_NID")
    private Long manpowerNid;



}