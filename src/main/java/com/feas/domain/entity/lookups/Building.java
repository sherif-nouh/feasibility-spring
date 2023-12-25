package com.feas.domain.entity.lookups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٠٧/٠٢/٢٠٢٣
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Building implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "BUILD_ID")
    private long buildId;

    @Column(name = "BUILD_DESC")
    private String buildDesc;

    @Column(name = "BUILD_TYPE")
    private String buildType;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_STAMP")
    private Date dateStamp;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "USER_NAME")
    private String userName;
}