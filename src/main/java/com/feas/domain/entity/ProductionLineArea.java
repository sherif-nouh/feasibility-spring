package com.feas.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.feas.domain.entity.lookups.EquipmentCode;
import com.feas.domain.entity.lookups.TempRequest;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠٧/٠٢/٢٠٢٣
 */
@Entity
@Table(name="PRODUCTION_LINE_AREA")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ProductionLineArea implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name="custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
    @GeneratedValue(generator = "custom_seq")
    @Column(name = "PRODUCTION_LINE_AREA_ID")
    private long productionLineAreaId;

    @Column(name = "ADD_AREA_MOV_NR")
    private BigDecimal addAreaMovNr;

    @Column(name = "AREA_REQ_FOR_MACH_NR")
    private BigDecimal areaReqForMachNr;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_STAMP")
    private Date dateStamp;

    @Column(name = "EQUIP_CODE_IF")
   private BigDecimal equipCodeIf;

    @Column(name = "LICENSE_NUMBER_IF")
    private BigDecimal licenseNumberIf;

    @Column(name = "MACH_DIMENSION_LENGTH_NR")
    private BigDecimal machDimensionLengthNr;

    @Column(name = "MACH_DIMENSION_WIDTH_NR")
    private BigDecimal machDimensionWidthNr;

    @Column(name = "NO_OF_MACH_NR")
    private BigDecimal noOfMachNr;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "PROD_CAP_8H")
    private BigDecimal prodCap8h;

    @Column(name = "PRODUCTION_DESC")
    private String productionDesc;

    @Column(name = "PROJECT_NUMBER_IF")
    private BigDecimal projectNumberIf;

    @Column(name = "REQUEST_NUMBER_IF")
    private BigDecimal requestNumberIf;

    @Column(name = "SERIAL_NUMBER_ID")
    private BigDecimal serialNumberId;

    private BigDecimal sno;

    @Column(name = "USED_YN")
    private BigDecimal usedYn;

    @Column(name = "USER_NAME")
    private String userName;

    @Transient
    private BigDecimal total;
    @Transient
    private BigDecimal sumTotalProductionLine;
    @Transient

    private BigDecimal sumTotal;

    @Transient
    private BigDecimal vSummery;
    @Transient
    private BigDecimal sumVSummery;
    @Transient
    private BigDecimal totalAdditionalArea;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name="EQUIP_CODE_IF",insertable = false,updatable = false ,nullable = true)
    private EquipmentCode equipmentCode;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "REQUEST_NUMBER_IF" ,insertable = false,updatable = false)
    private TempRequest tempRequest;

    @PrePersist
    private void createDate(){
        this.dateStamp=new Date();
    }
    @PostLoad
    private void getSummaryFields(){
        calculateTotal();
        calculateVSummery();
    }
    private void calculateTotal(){
        BigDecimal sum1=null;
        BigDecimal sum2 =null;
        BigDecimal sum11=null;
        BigDecimal totals=null;
        if (this.machDimensionLengthNr==null){
            setMachDimensionLengthNr(new BigDecimal(0));
        }
        if (this.machDimensionWidthNr==null){
            setMachDimensionWidthNr(new BigDecimal(0));
        }
        if(this.serialNumberId == null){
            setSerialNumberId(new BigDecimal(0));
        }
        if(this.areaReqForMachNr == null){
            setAreaReqForMachNr(new BigDecimal(0));
        }

        if(this.noOfMachNr== null){
            setNoOfMachNr(new BigDecimal(0));
        }
        sum1=getMachDimensionLengthNr().multiply(getMachDimensionWidthNr());
        sum2 = sum1.add(getSerialNumberId());
        sum11 = sum2.multiply(new BigDecimal(getNoOfMachNr().intValue()));
        totals =new BigDecimal(Math.round(sum11.floatValue()));
        setTotal(totals);



    }

    private void calculateVSummery(){
        BigDecimal sum1=null;
        BigDecimal sum2 =null;
        BigDecimal sum11=null;
        BigDecimal totals=null;
        if (getMachDimensionLengthNr()==null){
            setMachDimensionLengthNr(new BigDecimal(0));
        }
        if (getMachDimensionWidthNr()==null){
            setMachDimensionWidthNr(new BigDecimal(0));
        }
        if(getSerialNumberId() == null){
            setSerialNumberId(new BigDecimal(0));
        }
        if(getAreaReqForMachNr() == null){
            setAreaReqForMachNr(new BigDecimal(0));
        }

        if(getNoOfMachNr() == null){
            setNoOfMachNr(new BigDecimal(0));
        }
        sum1=getMachDimensionLengthNr().multiply(getMachDimensionWidthNr());
        sum2 = sum1.add(getSerialNumberId());
        sum11 = sum2.multiply(new BigDecimal(getNoOfMachNr().intValue()));
        totals = new BigDecimal(Math.round(sum11.floatValue()));
        setVSummery( totals);
    }



}