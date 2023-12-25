package com.feas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.feas.domain.config.CheckUtils;
import com.feas.domain.entity.lookups.*;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠١/٠٢/٢٠٢٣
 */
@Entity
@Table(name="PROPOSED_STOCK")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProposedStock implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
    @GeneratedValue(generator = "custom_seq")
    @Column(name="PROPOSED_STOCK_ID")
    private long proposedStockId;

    @Column(name="ACTUAL_REMARKS_BY")
    private String actualRemarksBy;

    @Column(name="ACTUAL_REMARKS_TX")
    private String actualRemarksTx;

    @Column(name="APPROVED_REMARKS_BY")
    private String approvedRemarksBy;

    @Column(name="APPROVED_REMARKS_TX")
    private String approvedRemarksTx;

    private BigDecimal checked;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Column(name="EXCHANGE_RATE_CY")
    private BigDecimal exchangeRateCy;

    @Column(name="F_CODE_IF")
    private BigDecimal fCodeIf;

    @Column(name="LICENSE_NUMBER_IF")
    private BigDecimal licenseNumberIf;

    @Column(name="MAT_CODE_IF")
    private BigDecimal matCodeIf;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="PROD_CODE_IF")
    private BigDecimal prodCodeIf;

    @Column(name="PROD_ORIGIN_IF")
    private BigDecimal prodOriginIf;

    @Column(name="PROJECT_NUMBER_IF")
    private BigDecimal projectNumberIf;

    @Column(name="PROPOSED_REMARKS_BY")
    private String proposedRemarksBy;

    @Column(name="PROPOSED_REMARKS_TX")
    private String proposedRemarksTx;

    @Column(name="QUANTITY_ACTUAL")
    private BigDecimal quantityActual;

    @Column(name="QUANTITY_APPROVED")
    private BigDecimal quantityApproved;

    @Column(name="QUANTITY_NR")
    private BigDecimal quantityNr;

    @Column(name="RATIO_OF_FINGOODS")
    private BigDecimal ratioOfFingoods;

    @Column(name="REQUEST_NUMBER_IF")
    private BigDecimal requestNumberIf;

    @Column(name="SERIAL_NUMBER_ID")
    private BigDecimal serialNumberId;

    private BigDecimal sno;

    @Column(name="STOCK_TYPE")
    private BigDecimal stockType;

    @Column(name="STOCK_TYPE_TX")
    private String stockTypeTx;

    @Column(name="UNIT_PRICE_CY")
    private BigDecimal unitPriceCy;

    @Column(name="USER_NAME")
    private String userName;
    @Transient
    //@Formula("unitPriceCy * exchangeRateCy * quantityNr")
    private BigDecimal totalValue;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="PROD_CODE_IF",insertable = false,updatable = false)
    private Product product;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="REQUEST_NUMBER_IF",insertable = false,updatable = false)
    private TempRequest tempRequest;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="MAT_CODE_IF",insertable = false,updatable = false)
    private Unit unit;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="PROD_ORIGIN_IF" , insertable = false , updatable = false)
    private ProdOrigin prodOrigin;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="STOCK_TYPE" , insertable = false , updatable = false)
    private StockType stockTypes;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="F_CODE_IF" , insertable = false , updatable = false)
    private ForeignCurrency foreignCurrency;

    @PostLoad
    private void postLoad() {
        this.totalValue = this.exchangeRateCy.multiply(  this.quantityNr ).multiply( this.unitPriceCy);
        this.prodOriginIf= CheckUtils.isNullOrZero(this.prodOriginIf)?new BigDecimal(0):this.prodOriginIf;
        this.stockType=CheckUtils.isNullOrZero(this.stockType)?new BigDecimal(0):this.stockType;
    }

    @PreUpdate
    private void preUpdate(){
        this.dateStamp=new Date();
        this.quantityApproved=this.quantityNr;
    }
}