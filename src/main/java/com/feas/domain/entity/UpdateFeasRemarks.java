package com.feas.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="UPDATE_FEAS_REMARKS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class UpdateFeasRemarks implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "custom_seq", strategy = "com.feas.domain.config.SequenceGenerator")
    @GeneratedValue(generator = "custom_seq")
    @Column(name = "FEAS_ID")
    private Long feasId;
    @Column(name = "LICENSE_NUMBER_IF")
    private Long licenseNumberIf;
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "RELATION_KIND")
    private Long relationKind;
    @Column(name = "MODIFY_DATE")
    private Date modify_date;
    @Column(name = "ENERGY_CONSERV_YN")
    private String energyConservYn;
    @Column(name = "ENTER_BY")
    private Long enterBy;
    @Column(name = "ENTER_DATE")
    private Date enterDate;
    @Column(name = "MODIFY_BY")
    private Long modifyBy;
    @Column(name = "REQUEST_NUMBER_IF")
    private Long  requestNumberIf;
    @Column(name = "RECYCLE_YN")
    private String recycleYn;


}
