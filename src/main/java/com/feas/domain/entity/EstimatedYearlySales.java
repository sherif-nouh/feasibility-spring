package com.feas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.feas.domain.entity.lookups.Product;
import com.feas.domain.entity.lookups.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ESTIMATED_YEARLY_SALES database table.
 * 
 */
@Entity
@Table(name="ESTIMATED_YEARLY_SALES")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstimatedYearlySales implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
	@GeneratedValue(generator = "custom_seq")
	@Column(name="ESTIMATED_YEARLY_SALES_ID")
	private long estimatedYearlySalesId;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="END_QUANTITY")
	private BigDecimal endQuantity;

	@Column(name="END_VALUE")
	private BigDecimal endValue;

	@Temporal(TemporalType.DATE)
	@Column(name="FIN_END_DATE")
	private Date finEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="FIN_START_DATE")
	private Date finStartDate;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="PRODUCT_CODE_ID")
	private BigDecimal productCodeId;

	@Column(name="PRODUCT_DESC_TX")
	private String productDescTx;

	@Column(name="QUANTITY_NR")
	private BigDecimal quantityNr;

	@Column(name="REMARKS_TX")
	private String remarksTx;

	@Column(name="REQUEST_NUMBER_IF")
	private BigDecimal requestNumberIf;

	@Column(name="SALES_QUANTITY")
	private BigDecimal salesQuantity;

	@Column(name="SALES_VALUE")
	private BigDecimal salesValue;

	private BigDecimal sno;

	@Column(name="START_QUANTITY")
	private BigDecimal startQuantity;

	@Column(name="START_VALUE")
	private BigDecimal startValue;

	@Column(name="UNIT_CODE_IF")
	private BigDecimal unitCodeIf;

	@Column(name="UNIT_PRICE_CY")
	private BigDecimal unitPriceCy;
	@Column(name="LICENSE_NUMBER_IF")
	private long licenseNumberIf;
	@Column(name="PROJECT_NUMBER_IF")
	private long projectNumberIf;
	@Column(name="USER_NAME")
	private String userName;
	@Transient
	private BigDecimal totalPrice;
    @Transient
	private BigDecimal totalQuantity;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name = "PRODUCT_CODE_ID" ,updatable = false,insertable = false)
	private Product product;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name = "UNIT_CODE_IF", insertable = false, updatable = false)
	private Unit unit;
}