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
@Table(name="PROD_ORIGIN")
public class ProdOrigin implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="PROD_ORIGIN_DESC")
    private String prodOriginDesc;
    @Id
    @Column(name="PROD_ORIGIN_ID")
    private BigDecimal prodOriginId;

    public ProdOrigin() {
    }

    public String getProdOriginDesc() {
        return this.prodOriginDesc;
    }

    public void setProdOriginDesc(String prodOriginDesc) {
        this.prodOriginDesc = prodOriginDesc;
    }

    public BigDecimal getProdOriginId() {
        return this.prodOriginId;
    }

    public void setProdOriginId(BigDecimal prodOriginId) {
        this.prodOriginId = prodOriginId;
    }

}