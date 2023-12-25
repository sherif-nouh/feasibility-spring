package com.feas.domain.entity.lookups;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٧/٢٠٢٣
 */
@Entity
@Table(name="MANPOWER_CAT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ManpowerCat implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="MANPOWER_CODE_ID")
    private long manpowerCodeId;

    @Column(name="INSERT_BY")
    private String insertBy;

    @Temporal(TemporalType.DATE)
    @Column(name="INSERT_DT")
    private Date insertDt;

    @Column(name="MANPOWER_CAT_CODE")
    private BigDecimal manpowerCatCode;

    @Column(name="MANPOWER_CAT_TX")
    private String manpowerCatTx;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="UPDATE_BY")
    private String updateBy;

    @Temporal(TemporalType.DATE)
    @Column(name="UPDATE_DT")
    private Date updateDt;



}