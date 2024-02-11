package com.feas.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.feas.domain.entity.lookups.EquipmentType;
import com.feas.domain.entity.lookups.ManufCtry;
import com.feas.domain.entity.lookups.VehicalCode;
import com.feas.domain.entity.lookups.VehicalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="PROPOSED_CARRIER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProposedCarrier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name="custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
    @GeneratedValue(generator = "custom_seq")
    @Column(name="PROPOSED_CARRIER_ID")
    private Long proposedCarrierId;

    @Column(name="ACTUAL_REMARKS_TX")
    private String actualRemarksTx;

    @Column(name="APPROVED_REMARKS_TX")
    private String approvedRemarksTx;

 @Temporal(TemporalType.DATE)
    @Column(name="DATE_DT")
    private Date dateDt;
  @Temporal(TemporalType.DATE)
  @Column(name = "DATE_STAMP")
  private Date dateStamp;

    @Column(name="EXCHANGE_RATE_CY")
    private BigDecimal exchangeRateCy;

    @Column(name="FOREIGN_CODE_IF")
    private BigDecimal foreignCodeIf;

    @Column(name="LICENSE_NUMBER_IF")
    private Long licenseNumberIf;

    @Column(name="MANUF_CTRY_CODE_IF")
    private BigDecimal manufCtryCodeIf;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="PROJECT_NUMBER_IF")
    private Long projectNumberIf;

    @Column(name="PROPOSED_REMARKS_BY")
    private String proposedRemarksBy;

    @Column(name="QUANTITY_ACTUAL")
    private BigDecimal quantityActual;

    @Column(name="QUANTITY_APPROVED")
    private BigDecimal quantityApproved;

    @Column(name="QUANTITY_NR")
    private BigDecimal quantityNr;

    private String remarks;

    @Column(name="REMARKS_ACTUAL_BY")
    private String remarksActualBy;

    @Column(name="REMARKS_APPROVED_BY")
    private String remarksApprovedBy;

    @Column(name="REMARKS_PROPOSED_BY")
    private String remarksProposedBy;

    @Column(name="REQUEST_NUMBER_IF")
    private Long requestNumberIf;

    @Column(name="SERIAL_NUMBER_ID")
    private BigDecimal serialNumberId;

    @Column(name="UNIT_PRICE_CY")
    private BigDecimal unitPriceCy;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="VEH_CODE_IF")
    private BigDecimal vehCodeIf;

    @Column(name="VEH_TYPE")
    private BigDecimal vehType;

    @Column(name="VEHICAL_NAME")
    private String vehicalName;
    @Transient
    private BigDecimal intTransp;
    @Transient
    private BigDecimal extTransp;
    @Transient
    private BigDecimal sumTotalValue;
    @Transient
    private BigDecimal total;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "MANUF_CTRY_CODE_IF", insertable = false,updatable = false)
    private ManufCtry manufCtry;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "VEH_CODE_IF", insertable = false,updatable = false)
    private VehicalCode vehicalCode;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "VEH_TYPE", insertable = false,updatable = false)
    private VehicalType vehicalType;

}