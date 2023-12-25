package com.feas.domain.entity.lookups;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the EQUIPMENT_TYPE database table.
 * 
 */
@Entity
@Table(name="EQUIPMENT_TYPE")
@NamedQuery(name="EquipmentType.findAll", query="SELECT e FROM EquipmentType e")
public class EquipmentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EQUIP_KIND_CODE")
	private long equipKindCode;

	@Column(name="EQUIP_KIND_DESC")
	private String equipKindDesc;

	public EquipmentType() {
	}

	public long getEquipKindCode() {
		return this.equipKindCode;
	}

	public void setEquipKindCode(long equipKindCode) {
		this.equipKindCode = equipKindCode;
	}

	public String getEquipKindDesc() {
		return this.equipKindDesc;
	}

	public void setEquipKindDesc(String equipKindDesc) {
		this.equipKindDesc = equipKindDesc;
	}

}