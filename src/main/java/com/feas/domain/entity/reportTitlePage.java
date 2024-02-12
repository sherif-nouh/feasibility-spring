package com.feas.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="REPORT_TITLE_PAGE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class reportTitlePage implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "REPORT_TIT_PAG_ID")
    private BigDecimal reportTitPagId;


    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_STAMP")
    private Date dateStamp;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "REQUEST_NUMBER_IF")
    private BigDecimal requestNumberIf;

    @Column(name = "PROJECT_NUMBER_IF")
    private BigDecimal projectNumberIf;

    @Column(name = "LICENSE_NUMBER_IF")
    private BigDecimal licenseNumberIf;

    @Column(name = "TITLE_TX")
    private String titleTx;
}