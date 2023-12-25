package com.feas.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the BREAKEVEN_POINT database table.
 * 
 */
@Entity
@Table(name="BREAKEVEN_POINT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BreakevenPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BreakevenPointPK id;

	@Column(name="BREAKEVEN_POINT_PERC")
	private BigDecimal breakevenPointPerc;

	@Column(name="CAPITAL_DENSITY_CY")
	private BigDecimal capitalDensityCy;

	@Column(name="ESTIM_TOT_INVESTMENT_CY")
	private BigDecimal estimTotInvestmentCy;

	@Column(name="FIXED_COST_CY")
	private BigDecimal fixedCostCy;

	@Column(name="FIXED_EXPENCES_CY")
	private BigDecimal fixedExpencesCy;

	@Column(name="GROSS_INVESTMENT_CY")
	private BigDecimal grossInvestmentCy;

	@Column(name="INDUSTRIAL_PROFIT_CY")
	private BigDecimal industrialProfitCy;

	@Column(name="NET_PROJECT_PROFIT")
	private BigDecimal netProjectProfit;

	@Column(name="NO_OF_EMP_NR")
	private BigDecimal noOfEmpNr;

	@Column(name="PAYBACK_PERIOD_TOT_INV_CY")
	private BigDecimal paybackPeriodTotInvCy;

	@Column(name="YEARLY_DEPRICIATION_CY")
	private BigDecimal yearlyDepriciationCy;

	@Column(name="YEARLY_PRODUCTION_NR")
	private BigDecimal yearlyProductionNr;

	@Column(name="YEARLY_SALES_CY")
	private BigDecimal yearlySalesCy;





}