package com.feas.domain.entity.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠١/٠٢/٢٠٢٣
 */
public class ProposedStockDTO  implements ProposedStock{
    private long proposedStockId;
    private String actualRemarksBy;
    private String actualRemarksTx;
    private String approvedRemarksBy;
    private String approvedRemarksTx;
    private BigDecimal checked;
    private Date dateStamp;
    private BigDecimal exchangeRateCy;
    private BigDecimal fCodeIf;
    private BigDecimal licenseNumberIf;
    private BigDecimal matCodeIf;
    private String operation;
    private BigDecimal prodCodeIf;
    private BigDecimal prodOriginIf;
    private BigDecimal projectNumberIf;
    private String proposedRemarksBy;
    private String proposedRemarksTx;
    private BigDecimal quantityActual;
    private BigDecimal quantityApproved;
    private BigDecimal quantityNr;
    private BigDecimal ratioOfFingoods;
    private BigDecimal requestNumberIf;
    private BigDecimal serialNumberId;
    private BigDecimal sno;
    private BigDecimal stockType;
    private String stockTypeTx;
    private BigDecimal unitPriceCy;
    private String userName;

    public ProposedStockDTO() {
    }

    public ProposedStockDTO(long proposedStockId, String actualRemarksBy, String actualRemarksTx, String approvedRemarksBy, String approvedRemarksTx, BigDecimal checked, Date dateStamp, BigDecimal exchangeRateCy, BigDecimal fCodeIf, BigDecimal licenseNumberIf, BigDecimal matCodeIf, String operation, BigDecimal prodCodeIf, BigDecimal prodOriginIf, BigDecimal projectNumberIf, String proposedRemarksBy, String proposedRemarksTx, BigDecimal quantityActual, BigDecimal quantityApproved, BigDecimal quantityNr, BigDecimal ratioOfFingoods, BigDecimal requestNumberIf, BigDecimal serialNumberId, BigDecimal sno, BigDecimal stockType, String stockTypeTx, BigDecimal unitPriceCy, String userName) {
        this.proposedStockId = proposedStockId;
        this.actualRemarksBy = actualRemarksBy;
        this.actualRemarksTx = actualRemarksTx;
        this.approvedRemarksBy = approvedRemarksBy;
        this.approvedRemarksTx = approvedRemarksTx;
        this.checked = checked;
        this.dateStamp = dateStamp;
        this.exchangeRateCy = exchangeRateCy;
        this.fCodeIf = fCodeIf;
        this.licenseNumberIf = licenseNumberIf;
        this.matCodeIf = matCodeIf;
        this.operation = operation;
        this.prodCodeIf = prodCodeIf;
        this.prodOriginIf = prodOriginIf;
        this.projectNumberIf = projectNumberIf;
        this.proposedRemarksBy = proposedRemarksBy;
        this.proposedRemarksTx = proposedRemarksTx;
        this.quantityActual = quantityActual;
        this.quantityApproved = quantityApproved;
        this.quantityNr = quantityNr;
        this.ratioOfFingoods = ratioOfFingoods;
        this.requestNumberIf = requestNumberIf;
        this.serialNumberId = serialNumberId;
        this.sno = sno;
        this.stockType = stockType;
        this.stockTypeTx = stockTypeTx;
        this.unitPriceCy = unitPriceCy;
        this.userName = userName;
    }

    public long getProposedStockId() {
        return proposedStockId;
    }

    public String getActualRemarksBy() {
        return actualRemarksBy;
    }

    public String getActualRemarksTx() {
        return actualRemarksTx;
    }

    public String getApprovedRemarksBy() {
        return approvedRemarksBy;
    }

    public String getApprovedRemarksTx() {
        return approvedRemarksTx;
    }

    public BigDecimal getChecked() {
        return checked;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public BigDecimal getExchangeRateCy() {
        return exchangeRateCy;
    }

    public BigDecimal getfCodeIf() {
        return fCodeIf;
    }

    public BigDecimal getLicenseNumberIf() {
        return licenseNumberIf;
    }

    public BigDecimal getMatCodeIf() {
        return matCodeIf;
    }

    public String getOperation() {
        return operation;
    }

    public BigDecimal getProdCodeIf() {
        return prodCodeIf;
    }

    public BigDecimal getProdOriginIf() {
        return prodOriginIf;
    }

    public BigDecimal getProjectNumberIf() {
        return projectNumberIf;
    }

    public String getProposedRemarksBy() {
        return proposedRemarksBy;
    }

    public String getProposedRemarksTx() {
        return proposedRemarksTx;
    }

    public BigDecimal getQuantityActual() {
        return quantityActual;
    }

    public BigDecimal getQuantityApproved() {
        return quantityApproved;
    }

    public BigDecimal getQuantityNr() {
        return quantityNr;
    }

    public BigDecimal getRatioOfFingoods() {
        return ratioOfFingoods;
    }

    public BigDecimal getRequestNumberIf() {
        return requestNumberIf;
    }

    public BigDecimal getSerialNumberId() {
        return serialNumberId;
    }

    public BigDecimal getSno() {
        return sno;
    }

    public BigDecimal getStockType() {
        return stockType;
    }

    public String getStockTypeTx() {
        return stockTypeTx;
    }

    public BigDecimal getUnitPriceCy() {
        return unitPriceCy;
    }

    public String getUserName() {
        return userName;
    }

    public void setProposedStockId(long proposedStockId) {
        this.proposedStockId = proposedStockId;
    }

    public void setActualRemarksBy(String actualRemarksBy) {
        this.actualRemarksBy = actualRemarksBy;
    }

    public void setActualRemarksTx(String actualRemarksTx) {
        this.actualRemarksTx = actualRemarksTx;
    }

    public void setApprovedRemarksBy(String approvedRemarksBy) {
        this.approvedRemarksBy = approvedRemarksBy;
    }

    public void setApprovedRemarksTx(String approvedRemarksTx) {
        this.approvedRemarksTx = approvedRemarksTx;
    }

    public void setChecked(BigDecimal checked) {
        this.checked = checked;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public void setExchangeRateCy(BigDecimal exchangeRateCy) {
        this.exchangeRateCy = exchangeRateCy;
    }

    public void setfCodeIf(BigDecimal fCodeIf) {
        this.fCodeIf = fCodeIf;
    }

    public void setLicenseNumberIf(BigDecimal licenseNumberIf) {
        this.licenseNumberIf = licenseNumberIf;
    }

    public void setMatCodeIf(BigDecimal matCodeIf) {
        this.matCodeIf = matCodeIf;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setProdCodeIf(BigDecimal prodCodeIf) {
        this.prodCodeIf = prodCodeIf;
    }

    public void setProdOriginIf(BigDecimal prodOriginIf) {
        this.prodOriginIf = prodOriginIf;
    }

    public void setProjectNumberIf(BigDecimal projectNumberIf) {
        this.projectNumberIf = projectNumberIf;
    }

    public void setProposedRemarksBy(String proposedRemarksBy) {
        this.proposedRemarksBy = proposedRemarksBy;
    }

    public void setProposedRemarksTx(String proposedRemarksTx) {
        this.proposedRemarksTx = proposedRemarksTx;
    }

    public void setQuantityActual(BigDecimal quantityActual) {
        this.quantityActual = quantityActual;
    }

    public void setQuantityApproved(BigDecimal quantityApproved) {
        this.quantityApproved = quantityApproved;
    }

    public void setQuantityNr(BigDecimal quantityNr) {
        this.quantityNr = quantityNr;
    }

    public void setRatioOfFingoods(BigDecimal ratioOfFingoods) {
        this.ratioOfFingoods = ratioOfFingoods;
    }

    public void setRequestNumberIf(BigDecimal requestNumberIf) {
        this.requestNumberIf = requestNumberIf;
    }

    public void setSerialNumberId(BigDecimal serialNumberId) {
        this.serialNumberId = serialNumberId;
    }

    public void setSno(BigDecimal sno) {
        this.sno = sno;
    }

    public void setStockType(BigDecimal stockType) {
        this.stockType = stockType;
    }

    public void setStockTypeTx(String stockTypeTx) {
        this.stockTypeTx = stockTypeTx;
    }

    public void setUnitPriceCy(BigDecimal unitPriceCy) {
        this.unitPriceCy = unitPriceCy;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
