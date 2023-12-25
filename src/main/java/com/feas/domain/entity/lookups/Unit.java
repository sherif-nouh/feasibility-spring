package com.feas.domain.entity.lookups;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٢/٢٠٢٣
 */
@Entity
public class Unit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="UNIT_CODE_ID")
    private long unitCodeId;

    @Column(name="COMP_UNIT_CODE_IF")
    private BigDecimal compUnitCodeIf;

    @Column(name="CUST_ABREV")
    private String custAbrev;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="QTY_OF_COMP_UNIT_NR")
    private BigDecimal qtyOfCompUnitNr;

    @Column(name="UNIT_ABV")
    private String unitAbv;

    @Column(name="UNIT_DESC_TX")
    private String unitDescTx;

    @Column(name="USER_NAME")
    private String userName;

    public Unit() {
    }

    public long getUnitCodeId() {
        return this.unitCodeId;
    }

    public void setUnitCodeId(long unitCodeId) {
        this.unitCodeId = unitCodeId;
    }

    public BigDecimal getCompUnitCodeIf() {
        return this.compUnitCodeIf;
    }

    public void setCompUnitCodeIf(BigDecimal compUnitCodeIf) {
        this.compUnitCodeIf = compUnitCodeIf;
    }

    public String getCustAbrev() {
        return this.custAbrev;
    }

    public void setCustAbrev(String custAbrev) {
        this.custAbrev = custAbrev;
    }

    public Date getDateStamp() {
        return this.dateStamp;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigDecimal getQtyOfCompUnitNr() {
        return this.qtyOfCompUnitNr;
    }

    public void setQtyOfCompUnitNr(BigDecimal qtyOfCompUnitNr) {
        this.qtyOfCompUnitNr = qtyOfCompUnitNr;
    }

    public String getUnitAbv() {
        return this.unitAbv;
    }

    public void setUnitAbv(String unitAbv) {
        this.unitAbv = unitAbv;
    }

    public String getUnitDescTx() {
        return this.unitDescTx;
    }

    public void setUnitDescTx(String unitDescTx) {
        this.unitDescTx = unitDescTx;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}