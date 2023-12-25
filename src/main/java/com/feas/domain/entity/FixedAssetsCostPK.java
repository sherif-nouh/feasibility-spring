package com.feas.domain.entity;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the FIXED_ASSETS_COST database table.
 * 
 */
@Embeddable
public class FixedAssetsCostPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROJECT_NUMBER_IF", insertable=false, updatable=false)
	private long projectNumberIf;

	@Column(name="REQUEST_NUMBER_IF", insertable=false, updatable=false)
	private long requestNumberIf;

	@Column(name="LICENSE_NUMBER_IF", insertable=false, updatable=false)
	private long licenseNumberIf;

	public FixedAssetsCostPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FixedAssetsCostPK)) {
			return false;
		}
		FixedAssetsCostPK castOther = (FixedAssetsCostPK)other;
		return 
			(this.projectNumberIf == castOther.projectNumberIf)
			&& (this.requestNumberIf == castOther.requestNumberIf)
			&& (this.licenseNumberIf == castOther.licenseNumberIf);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.projectNumberIf ^ (this.projectNumberIf >>> 32)));
		hash = hash * prime + ((int) (this.requestNumberIf ^ (this.requestNumberIf >>> 32)));
		hash = hash * prime + ((int) (this.licenseNumberIf ^ (this.licenseNumberIf >>> 32)));
		
		return hash;
	}
}