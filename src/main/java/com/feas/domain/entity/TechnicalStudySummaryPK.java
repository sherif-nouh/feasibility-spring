package com.feas.domain.entity;


import java.io.Serializable;


public class TechnicalStudySummaryPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    private long projectNumberIf;

    private long requestNumberIf;

    private long licenseNumberIf;

    public TechnicalStudySummaryPK() {
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