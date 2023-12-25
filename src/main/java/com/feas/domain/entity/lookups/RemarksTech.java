package com.feas.domain.entity.lookups;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢١/٠٦/٢٠٢٣
 */
@Entity
@Table(name="REMARKS_TECH")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RemarksTech implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name="custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
    @GeneratedValue(generator = "custom_seq")
    @Column(name="REMARKS_TECH_ID")
    private long remarksTechId;

    @Temporal(TemporalType.DATE)
    @Column(name="DT_REMARKS")
    private Date dtRemarks;

    @Column(name="INSERT_BY")
    private BigDecimal insertBy;

    @Temporal(TemporalType.DATE)
    @Column(name="INSERT_DT")
    private Date insertDt;

    @Column(name="LICENSE_NUMBER_IF")
    private BigDecimal licenseNumberIf;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="PROJECT_NUMBER_IF")
    private BigDecimal projectNumberIf;

    @Column(name="REMARKS_PROD_PROCESS")
    private String remarksProdProcess;

    @Column(name="REMARKS_STAND_SPECIFY")
    private String remarksStandSpecify;

    @Column(name="REQUEST_NUMBER_IF")
    private BigDecimal requestNumberIf;

    @Column(name="UPDATE_BY")
    private BigDecimal updateBy;

    @Temporal(TemporalType.DATE)
    @Column(name="UPDATE_DT")
    private Date updateDt;

    @PrePersist
    private void createDate(){
        this.insertDt=new Date();
        this.operation="I";
    }

    @PreUpdate
    private void updateDate(){
        this.updateDt=new Date();
        if(this.operation!="D") {
            this.operation = "U";
        }
    }
}