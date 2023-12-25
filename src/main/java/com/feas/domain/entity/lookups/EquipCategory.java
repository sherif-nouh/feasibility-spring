package com.feas.domain.entity.lookups;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the EQUIP_CATEGORY database table.
 * 
 */
@Entity
@Table(name="EQUIP_CATEGORY")
@NamedQuery(name="EquipCategory.findAll", query="SELECT e FROM EquipCategory e")
public class EquipCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EQUIP_CAT_CODE")
	private long equipCatCode;

	@Column(name="EQUIP_CAT_DESC")
	private String equipCatDesc;

	public EquipCategory() {
	}

	public long getEquipCatCode() {
		return this.equipCatCode;
	}

	public void setEquipCatCode(long equipCatCode) {
		this.equipCatCode = equipCatCode;
	}

	public String getEquipCatDesc() {
		return this.equipCatDesc;
	}

	public void setEquipCatDesc(String equipCatDesc) {
		this.equipCatDesc = equipCatDesc;
	}

}