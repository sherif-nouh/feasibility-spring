package com.feas.domain.entity.lookups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠٥/٠٢/٢٠٢٣
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MAT_CODE_ID")
    private long matCodeId;

    @Column(name = "CUST_UNIT_CODE")
    private BigDecimal custUnitCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_STAMP")
    private Date dateStamp;

    @Column(name = "MAT_NAME_TX")
    private String matNameTx;

    @Column(name = "MAT_TYPE_IF")
    private BigDecimal matTypeIf;

    @Column(name = "MAT_TYPE_TX")
    private String matTypeTx;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "UNIT_CODE_IF")
    private BigDecimal unitCodeIf;

    @Column(name = "USER_NAME")
    private String userName;
}