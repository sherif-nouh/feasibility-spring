package com.feas.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.feas.domain.entity.lookups.Product;
import com.feas.domain.entity.lookups.TempRequest;
import com.feas.domain.entity.lookups.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠٨/٠٢/٢٠٢٣
 */
@Entity
@Table(name="FINISHED_GOODS_STORAGE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FinishedGoodsStorage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
    @GeneratedValue(generator = "custom_seq")
    @Column(name="FINISHED_GOODS_STORAGE_ID")
    private long finishedGoodsStorageId;

    @Column(name="AREA_FOR_STORAGE_NR")
    private BigDecimal areaForStorageNr;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Column(name="DIM_MEHTOD_TX")
    private String dimMehtodTx;

    @Column(name="FINISHED_RECEIVE_METHOD_TX")
    private String finishedReceiveMethodTx;

    @Column(name="LICENSE_NUMBER_IF")
    private BigDecimal licenseNumberIf;

    @Column(name="MANUF_ORIGIN_IF")
    private BigDecimal manufOriginIf;

    @Column(name="METHOD_OF_STORAGE")
    private String methodOfStorage;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="PERC_ADD_AREA_NR")
    private BigDecimal percAddAreaNr;

    @Column(name="PERIOD_FOR_STOR_NR")
    private String periodForStorNr;

    @Column(name="PRODUCT_CODE_UPC_IF")
    private BigDecimal productCodeUpcIf;

    @Column(name="PROJECT_NUMBER_IF")
    private BigDecimal projectNumberIf;

    @Column(name="QTY_OF_STOR_FOR_PERIOD_NR")
    private String qtyOfStorForPeriodNr;

    @Column(name="QUANTITY_PER_YEAR_NR")
    private BigDecimal quantityPerYearNr;

    @Column(name="REQUEST_NUMBER_IF")
    private BigDecimal requestNumberIf;

    @Column(name="ROOM_NR")
    private BigDecimal roomNr;

    @Column(name="SERIAL_NUMBER_ID")
    private BigDecimal serialNumberId;

    private BigDecimal sno;

    @Column(name="STORAGE_METHOD_TX")
    private String storageMethodTx;

    @Column(name="UNIT_CODE_IF")
    private BigDecimal unitCodeIf;

    @Column(name="UNIT_OF_PERIOD_TX")
    private String unitOfPeriodTx;

    @Column(name="UNITS_STORED_NR")
    private String unitsStoredNr;

    @Column(name="USER_NAME")
    private String userName;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="PRODUCT_CODE_UPC_IF",insertable = false,updatable = false)
    private Product product;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "REQUEST_NUMBER_IF", insertable = false, updatable = false)
    private TempRequest tempRequest;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "UNIT_CODE_IF", insertable = false, updatable = false)
    private Unit unit;

}