package com.feas.domain.entity.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠١/٠٢/٢٠٢٣
 */
public interface ProposedStock {
    public long getProposedStockId() ;

    public String getActualRemarksBy() ;
    public String getActualRemarksTx() ;

    public String getApprovedRemarksBy() ;

    public String getApprovedRemarksTx() ;

    public BigDecimal getChecked() ;

    public Date getDateStamp() ;

    public BigDecimal getExchangeRateCy() ;

    public BigDecimal getfCodeIf() ;

    public BigDecimal getLicenseNumberIf() ;

    public BigDecimal getMatCodeIf() ;

    public String getOperation() ;

    public BigDecimal getProdCodeIf() ;

    public BigDecimal getProdOriginIf() ;

    public BigDecimal getProjectNumberIf() ;

    public String getProposedRemarksBy() ;

    public String getProposedRemarksTx() ;

    public BigDecimal getQuantityActual() ;

    public BigDecimal getQuantityApproved() ;

    public BigDecimal getQuantityNr() ;

    public BigDecimal getRatioOfFingoods() ;

    public BigDecimal getRequestNumberIf() ;

    public BigDecimal getSerialNumberId() ;

    public BigDecimal getSno() ;

    public BigDecimal getStockType() ;

    public String getStockTypeTx() ;

    public BigDecimal getUnitPriceCy() ;

    public String getUserName() ;
}
