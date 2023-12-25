package com.feas.domain.entity.lookups;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the COUNTRY database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COUNTRY_CODE_ID")
	private long countryCodeId;

	@Column(name="COUNTRY_TX")
	private String countryTx;

	private String custom;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="FOREIGN_CURR_CODE_IF")
	private BigDecimal foreignCurrCodeIf;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="USER_NAME")
	private String userName;

	public Country() {
	}

	public long getCountryCodeId() {
		return this.countryCodeId;
	}

	public void setCountryCodeId(long countryCodeId) {
		this.countryCodeId = countryCodeId;
	}

	public String getCountryTx() {
		return this.countryTx;
	}

	public void setCountryTx(String countryTx) {
		this.countryTx = countryTx;
	}

	public String getCustom() {
		return this.custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public Date getDateStamp() {
		return this.dateStamp;
	}

	public void setDateStamp(Date dateStamp) {
		this.dateStamp = dateStamp;
	}

	public BigDecimal getForeignCurrCodeIf() {
		return this.foreignCurrCodeIf;
	}

	public void setForeignCurrCodeIf(BigDecimal foreignCurrCodeIf) {
		this.foreignCurrCodeIf = foreignCurrCodeIf;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}