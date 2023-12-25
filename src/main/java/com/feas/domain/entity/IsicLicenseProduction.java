package com.feas.domain.entity;

import com.feas.domain.entity.lookups.IsicLookup;
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
 * @Date ١٤/٠٢/٢٠٢٣
 */
@Entity
@Table(name="ISIC_LICENSE_PRODUCTION")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IsicLicenseProduction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name="ACTION")
    private String action;

    @Column(name="ACTION_BY")
    private Long actionBy;

    @Temporal(TemporalType.DATE)
    @Column(name="ACTION_DATE")
    private Date actionDate;

    @Column(name="ISIC_IF")
    private long isicIf;

    @Column(name="LICENSE_NUMBER_IF")
    private long licenseNumberIf;
    @Id
    @GenericGenerator(name = "custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
    @GeneratedValue(generator = "custom_seq")
    @Column(name="LICENSE_PRODUCTION_ID")
    private long licenseProductionId;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="REQUEST_NUMBER_IF")
    private long requestNumberIf;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ISIC_IF" ,insertable = false,updatable = false,referencedColumnName = "ISIC_CODE")
    private IsicLookup isicLookup;

    @PrePersist
    private void createDate(){
        this.actionDate=new Date();
        this.operation="I";
        this.action="I";
    }

    @PreUpdate
    private void updateDate(){
        if(this.operation!="D") {
            this.operation = "U";
        }
    }
}