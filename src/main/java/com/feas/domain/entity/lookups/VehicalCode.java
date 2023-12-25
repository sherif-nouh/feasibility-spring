package com.feas.domain.entity.lookups;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sherif Nouh
 * @Date ٣١/٠٥/٢٠٢٣
 */
@Entity
@Table(name="VEHICAL_CODE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicalCode implements Serializable {
    @Id
    @Column(name="VEH_CODE_ID")
    private long vehCodeId;

    @Column(name="CARRYING_CAP_NR")
    private BigDecimal carryingCapNr;

    @Column(name="CARRYING_UNIT_IF")
    private BigDecimal carryingUnitIf;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_STAMP")
    private Date dateStamp;

    @Column(name="OPERATION")
    private String operation;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="VEH_NAME_TX")
    private String vehNameTx;

    @Column(name="VEH_TYPE_TX")
    private BigDecimal vehTypeTx;

}
