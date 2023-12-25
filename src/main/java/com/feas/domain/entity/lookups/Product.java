package com.feas.domain.entity.lookups;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROD_CODE_MIN_ID")
	private long prodCodeMinId;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="PROD_CAT_CODE_IF")
	private BigDecimal prodCatCodeIf;

	@Column(name="PROD_CODE_UPC_ID")
	private BigDecimal prodCodeUpcId;

	@Column(name="PROD_DESC_TX")
	private String prodDescTx;

	@Column(name="PROD_NAME")
	private String prodName;

	@Column(name="PROD_NAME_TX")
	private String prodNameTx;

	@Column(name="PROD_TYPE_TX")
	private String prodTypeTx;

	@Column(name="PRODUCT_CAT_IF")
	private BigDecimal productCatIf;

	@Column(name="UNIT_CODE_IF")
	private BigDecimal unitCodeIf;

	@Column(name="USER_NAME")
	private String userName;

	public Product() {
	}

	public long getProdCodeMinId() {
		return this.prodCodeMinId;
	}

	public void setProdCodeMinId(long prodCodeMinId) {
		this.prodCodeMinId = prodCodeMinId;
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

	public BigDecimal getProdCatCodeIf() {
		return this.prodCatCodeIf;
	}

	public void setProdCatCodeIf(BigDecimal prodCatCodeIf) {
		this.prodCatCodeIf = prodCatCodeIf;
	}

	public BigDecimal getProdCodeUpcId() {
		return this.prodCodeUpcId;
	}

	public void setProdCodeUpcId(BigDecimal prodCodeUpcId) {
		this.prodCodeUpcId = prodCodeUpcId;
	}

	public String getProdDescTx() {
		return this.prodDescTx;
	}

	public void setProdDescTx(String prodDescTx) {
		this.prodDescTx = prodDescTx;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdNameTx() {
		return this.prodNameTx;
	}

	public void setProdNameTx(String prodNameTx) {
		this.prodNameTx = prodNameTx;
	}

	public String getProdTypeTx() {
		return this.prodTypeTx;
	}

	public void setProdTypeTx(String prodTypeTx) {
		this.prodTypeTx = prodTypeTx;
	}

	public BigDecimal getProductCatIf() {
		return this.productCatIf;
	}

	public void setProductCatIf(BigDecimal productCatIf) {
		this.productCatIf = productCatIf;
	}

	public BigDecimal getUnitCodeIf() {
		return this.unitCodeIf;
	}

	public void setUnitCodeIf(BigDecimal unitCodeIf) {
		this.unitCodeIf = unitCodeIf;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}