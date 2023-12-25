package com.feas.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

public class EconomicalStudySummaryPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name="PROJECT_NUMBER_IF")
    private long projectNumberIf;

    @Column(name="REQUEST_NUMBER_IF")
    private long requestNumberIf;

    @Column(name="LICENSE_NUMBER_IF")
    private long licenseNumberIf;

    public EconomicalStudySummaryPK() {
    }

    public long getProjectNumberIf() {
        return projectNumberIf;
    }

    public void setProjectNumberIf(long projectNumberIf) {
        this.projectNumberIf = projectNumberIf;
    }

    public long getRequestNumberIf() {
        return requestNumberIf;
    }

    public void setRequestNumberIf(long requestNumberIf) {
        this.requestNumberIf = requestNumberIf;
    }

    public long getLicenseNumberIf() {
        return licenseNumberIf;
    }

    public void setLicenseNumberIf(long licenseNumberIf) {
        this.licenseNumberIf = licenseNumberIf;
    }
}