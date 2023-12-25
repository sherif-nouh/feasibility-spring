package com.feas.domain.entity.lookups;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Sherif Nouh
 * @Date ٠٢/٠٢/٢٠٢٣
 */
@Entity
@Table(name="STOCK_TYPE")
public class StockType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="STOCK_TYPE_DESC")
    private String stockTypeDesc;
    @Id
    @Column(name="STOCK_TYPE_ID")
    private BigDecimal stockTypeId;

    public StockType() {
    }

    public String getStockTypeDesc() {
        return this.stockTypeDesc;
    }

    public void setStockTypeDesc(String stockTypeDesc) {
        this.stockTypeDesc = stockTypeDesc;
    }

    public BigDecimal getStockTypeId() {
        return this.stockTypeId;
    }

    public void setStockTypeId(BigDecimal stockTypeId) {
        this.stockTypeId = stockTypeId;
    }

}