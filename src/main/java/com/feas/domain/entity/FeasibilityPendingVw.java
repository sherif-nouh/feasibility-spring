package com.feas.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="FEASIBILITY_PENDING_VW")
@Data
@IdClass(FeasibilityPendingVwKey.class)
public class FeasibilityPendingVw implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "REQUEST_NO")
    private Long requestNo;
    @Id
    @Column(name = "LICENSE_NO")
    private String licenseNo;
    @Column(name = "PRODUCTION_KIND")
    private String productionKind;
    @Column(name = "TOTAL_INVESTMENT")
    private Long totalInvestment;
    @Column(name = "APPROVAL_DATE")
    private Date approvalDate;
    @Column(name = "AREA_SIZE")
    private Long areaSize;
    @Column(name = "POST_BOX")
    private String postBox;
    @Column(name = "TELE_1")
    private String tele1;
    @Column(name = "MOBILE_NO")
    private String mobileNo;
    @Column(name = "SECTOR")
    private String sector;
    @Column(name = "MANPOWER_SUM")
    private Long manpowerSum;
   @Id
    @Column(name = "REQUEST_NUMBER_ID")
    private long requestNumberId;

    public FeasibilityPendingVw() {
    }

    public FeasibilityPendingVw(long requestNo, String licenseNo, String productionKind, long totalInvestment, Date approvalDate, long areaSize, String postBox, String tele1, String mobileNo, String sector, long manpowerSum, long requestNumberId) {
        this.requestNo = requestNo;
        this.licenseNo = licenseNo;
        this.productionKind = productionKind;
        this.totalInvestment = totalInvestment;
        this.approvalDate = approvalDate;
        this.areaSize = areaSize;
        this.postBox = postBox;
        this.tele1 = tele1;
        this.mobileNo = mobileNo;
        this.sector = sector;
        this.manpowerSum = manpowerSum;
        this.requestNumberId = requestNumberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FeasibilityPendingVw that)) return false;
        return requestNo == that.requestNo && totalInvestment == that.totalInvestment && areaSize == that.areaSize && manpowerSum == that.manpowerSum && requestNumberId == that.requestNumberId && Objects.equals(licenseNo, that.licenseNo) && Objects.equals(productionKind, that.productionKind) && Objects.equals(approvalDate, that.approvalDate) && Objects.equals(postBox, that.postBox) && Objects.equals(tele1, that.tele1) && Objects.equals(mobileNo, that.mobileNo) && Objects.equals(sector, that.sector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestNo, licenseNo, productionKind, totalInvestment, approvalDate, areaSize, postBox, tele1, mobileNo, sector, manpowerSum, requestNumberId);
    }


}
