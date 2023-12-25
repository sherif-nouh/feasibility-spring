package com.feas.domain.entity.lookups;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٧/٢٠٢٣
 */
@Entity
@Table(name="MANPOWER_TYPE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ManpowerType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="MANPOWER_CODE_ID")
    private long manpowerCodeId;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Column(name="MANPOWER_TYPE_TX")
    private String manpowerTypeTx;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="USER_NAME")
    private String userName;




}