package com.feas.domain.entity.lookups;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="REPORT_CONTENT_DEFULT")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ReportContentDefault implements Serializable {


    @Column(name="ORDER_NR")
    private BigDecimal orderNo;

    @Column(name="NUMBER_AR")
    private String numberAr;

    @Column(name="DETAIL_TX")
    private String detailTx;

    @Id
    @Column(name="CONTENT_ID")
    private BigDecimal contentId;


}


