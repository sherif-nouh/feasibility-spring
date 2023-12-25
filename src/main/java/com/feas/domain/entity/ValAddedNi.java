package com.feas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٢٣/٠٢/٢٠٢٣
 */
@Entity
@Table(name="VAL_ADDED_NI")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValAddedNi implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ECON_STUDY_NUMBER_IF")
    private long econStudyNumberIf;

    @Column(name="AUDITING_ACCOUNTS")
    private BigDecimal auditingAccounts;

    @Column(name="BUILDING_TOOLS")
    private BigDecimal buildingTools;

    @Column(name="INSERT_BY")
    private BigDecimal insertBy;

    @Temporal(TemporalType.DATE)
    @Column(name="INSERT_DT")
    private Date insertDt;

    @Column(name="LICENSE_NUMBER_IF")
    private BigDecimal licenseNumberIf;

    @Column(name="MODIFY_BY")
    private BigDecimal modifyBy;

    @Temporal(TemporalType.DATE)
    @Column(name="MODIFY_DT")
    private Date modifyDt;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="PROJECT_CHARGES")
    private BigDecimal projectCharges;

    @Column(name="PROJECT_NUMBER_IF")
    private BigDecimal projectNumberIf;

    @Column(name="PUBLICITY_ADV")
    private BigDecimal publicityAdv;

    private BigDecimal remigrations;

    @Column(name="REQUEST_NUMBER_IF")
    private BigDecimal requestNumberIf;

    @Column(name="VEH_INSUR_CY")
    private BigDecimal vehInsurCy;

    @Column(name="WORKER_REMUNERATION")
    private BigDecimal workerRemuneration;
    @Transient
    private BigDecimal totalValueAdded;
    @Transient
    private  BigDecimal interestOnLoan;
    @Transient
    private BigDecimal sumProjectProfit;

    @Transient
    private BigDecimal royalties;
    @Transient
    private BigDecimal projectRevenue;


}
