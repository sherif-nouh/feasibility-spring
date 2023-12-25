package com.feas.domain.entity.lookups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EQUIPMENT_CODE database table.
 * 
 */
@Entity
@Table(name="EQUIPMENT_CODE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EQUIP_ID")
	private long equipId;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_STAMP")
	private Date dateStamp;

	@Column(name="EQUIP_CAT_IF")
	private java.math.BigDecimal equipCatIf;

	@Column(name="EQUIP_NAME_TX")
	private String equipNameTx;

	@Column(name="EQUIP_TYPE_NR")
	private java.math.BigDecimal equipTypeNr;

	@Column(name="OPERATION")
	private String operation;

	@Column(name="UNIT_OF_MEASURE_IF")
	private java.math.BigDecimal unitOfMeasureIf;

	@Column(name="USER_NAME")
	private String userName;







}