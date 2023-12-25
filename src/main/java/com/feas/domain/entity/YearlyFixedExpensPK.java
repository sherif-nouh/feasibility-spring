package com.feas.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Sherif Nouh
 * @Date ٢١/٠٢/٢٠٢٣
 */
public class YearlyFixedExpensPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    private long projectNumberIf;

    private long requestNumberIf;

    private long licenseNumberIf;

    public YearlyFixedExpensPK() {
    }
    public long getProjectNumberIf() {
        return this.projectNumberIf;
    }
    public void setProjectNumberIf(long projectNumberIf) {
        this.projectNumberIf = projectNumberIf;
    }
    public long getRequestNumberIf() {
        return this.requestNumberIf;
    }
    public void setRequestNumberIf(long requestNumberIf) {
        this.requestNumberIf = requestNumberIf;
    }
    public long getLicenseNumberIf() {
        return this.licenseNumberIf;
    }
    public void setLicenseNumberIf(long licenseNumberIf) {
        this.licenseNumberIf = licenseNumberIf;
    }


}