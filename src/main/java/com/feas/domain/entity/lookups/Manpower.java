package com.feas.domain.entity.lookups;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.feas.domain.entity.ProposedManpower;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Manpower implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="MANPOWER_CODE_ID")
    private long manpowerCodeId;

    @Column(name="DEPT_ID")
    private BigDecimal deptId;

    @Column(name="INSERT_BY")
    private String insertBy;

    @Temporal(TemporalType.DATE)
    @Column(name="INSERT_DT")
    private Date insertDt;

    @Column(name="MANP_TYPE_IF")
    private BigDecimal manpTypeIf;

    @Column(name="MANPOWER_CAT_IF")
    private BigDecimal manpowerCatIf;

    @Column(name="MANPOWER_NO")
    private String manpowerNo;

    @Column(name="MSA_ID")
    private BigDecimal msaId;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="TITLE_TX")
    private String titleTx;

    @Column(name="UPDATE_BY")
    private String updateBy;

    @Temporal(TemporalType.DATE)
    @Column(name="UPDATE_DT")
    private Date updateDt;


    public Manpower() {
    }

    public long getManpowerCodeId() {
        return this.manpowerCodeId;
    }

    public void setManpowerCodeId(long manpowerCodeId) {
        this.manpowerCodeId = manpowerCodeId;
    }

    public BigDecimal getDeptId() {
        return this.deptId;
    }

    public void setDeptId(BigDecimal deptId) {
        this.deptId = deptId;
    }

    public String getInsertBy() {
        return this.insertBy;
    }

    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    public Date getInsertDt() {
        return this.insertDt;
    }

    public void setInsertDt(Date insertDt) {
        this.insertDt = insertDt;
    }

    public BigDecimal getManpTypeIf() {
        return this.manpTypeIf;
    }

    public void setManpTypeIf(BigDecimal manpTypeIf) {
        this.manpTypeIf = manpTypeIf;
    }

    public BigDecimal getManpowerCatIf() {
        return this.manpowerCatIf;
    }

    public void setManpowerCatIf(BigDecimal manpowerCatIf) {
        this.manpowerCatIf = manpowerCatIf;
    }

    public String getManpowerNo() {
        return this.manpowerNo;
    }

    public void setManpowerNo(String manpowerNo) {
        this.manpowerNo = manpowerNo;
    }

    public BigDecimal getMsaId() {
        return this.msaId;
    }

    public void setMsaId(BigDecimal msaId) {
        this.msaId = msaId;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTitleTx() {
        return this.titleTx;
    }

    public void setTitleTx(String titleTx) {
        this.titleTx = titleTx;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDt() {
        return this.updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

}