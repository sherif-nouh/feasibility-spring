package com.feas.domain.entity.lookups;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FOREIGN_CURRENCY database table.
 * 
 */
@Entity
@Table(name="FOREIGN_CURRENCY")
@NamedQuery(name="ForeignCurrency.findAll", query="SELECT f FROM ForeignCurrency f")
public class ForeignCurrency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FOREIGN_CURR_CODE_ID")
	private long foreignCurrCodeId;

	@Column(name="CURRENCY_VALUE")
	private BigDecimal currencyValue;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="FOREIGN_CURR_NAME_TX")
	private String foreignCurrNameTx;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="USER_NAME")
	private String userName;

	public ForeignCurrency() {
	}

	public long getForeignCurrCodeId() {
		return this.foreignCurrCodeId;
	}

	public void setForeignCurrCodeId(long foreignCurrCodeId) {
		this.foreignCurrCodeId = foreignCurrCodeId;
	}

	public BigDecimal getCurrencyValue() {
		return this.currencyValue;
	}

	public void setCurrencyValue(BigDecimal currencyValue) {
		this.currencyValue = currencyValue;
	}

	public Date getDateStamp() {
		return this.dateStamp;
	}

	public void setDateStamp(Date dateStamp) {
		this.dateStamp = dateStamp;
	}

	public String getForeignCurrNameTx() {
		return this.foreignCurrNameTx;
	}

	public void setForeignCurrNameTx(String foreignCurrNameTx) {
		this.foreignCurrNameTx = foreignCurrNameTx;
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