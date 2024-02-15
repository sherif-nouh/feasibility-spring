package com.feas.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LICENSE_PRODUCTION")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LicenseProduction implements Serializable {
    @Id
    @Column(name = "LICENSE_PRODUCTION_ID")
    private Long licenseProductionId;
    @Column(name = "ISIC_IF")
    private Long isicIf;
    @Column(name = "ACTION_DATE")
    private Date actionDate;
    @Column(name = "ACTION")
    private String action;
    @Column(name = "ACTION_BY")
    private Long actionBy;
    @Column(name = "LICENSE_NUMBER_IF")
    private Long licenseNumberIf;
    @Column(name = "OPERATION")
    private String operation;
}
