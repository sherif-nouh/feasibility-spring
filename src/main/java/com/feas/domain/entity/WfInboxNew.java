package com.feas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the WF_INBOX_NEW database table.
 * 
 */
@Entity
@Table(name="WF_INBOX_NEW")
@NamedQuery(name="WfInboxNew.findAll", query="SELECT w FROM WfInboxNew w")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WfInboxNew implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="A_EDATE")
	private Date aEdate;

	@Temporal(TemporalType.DATE)
	@Column(name="A_SDATE")
	private Date aSdate;

	private String aname;

	@Column(name="APP_NAME")
	private String appName;

	@Column(name="APPLICANT_CIVILID_NR")
	private Long applicantCivilidNr;

	private String area;

	@Column(name="ASSIGN_BY")
	private Long assignBy;

	@Temporal(TemporalType.DATE)
	@Column(name="ASSIGN_DATE")
	private Date assignDate;

	@Column(name="ASSIGN_NAME")
	private String assignName;

	@Column(name="ASSIGN_TO")
	private Long assignTo;

	@Column(name="ASSING_REMARKS")
	private String assingRemarks;

	@Column(name="BY_USER")
	private String byUser;

	@Column(name="CURRENT_STATUS")
	private String currentStatus;

	@Column(name="DONE_USER")
	private String doneUser;

	@Column(name="EXT_COM_LP_IF")
	private String extComLpIf;

	@Column(name="FLAG_LIC")
	private BigDecimal flagLic;

	@Column(name="FLOW_ID")
	private Long flowId;

	@Column(name="FROM_DEPT")
	private String fromDept;

	@Column(name="FROM_DEPT_IF")
	private Long fromDeptIf;

	@Column(name="FROM_REMARKS")
	private String fromRemarks;

	@Column(name="LICENSE_NUMBER_IF")
	private Long licenseNumberIf;

	@Temporal(TemporalType.DATE)
	@Column(name="P_EDATE")
	private Date pEdate;

	@Temporal(TemporalType.DATE)
	@Column(name="P_SDATE")
	private Date pSdate;

	private String remarks;

	@Column(name="RENT_CONTRACT_IF")
	private Long rentContractIf;

	@Temporal(TemporalType.DATE)
	@Column(name="REQUEST_DT")
	private Date requestDt;

	@Id
	@Column(name="REQUEST_NUMBER_ID")
	private Long requestNumberId;

	@Column(name="RETURN_COLOR")
	private String returnColor;

	@Column(name="SER_ID")
	private Long serId;

	@Column(name="ST_STATUS")
	private String stStatus;

	@Column(name="STEP_NO")
	private Long stepNo;

	@Column(name="STEP_STATUS_IF")
	private BigDecimal stepStatusIf;

	@Column(name="SUB_REQ_NO")
	private Long subReqNo;

	@Column(name="TO_DEPT")
	private String toDept;

	@Column(name="TO_DEPT_IF")
	private Long toDeptIf;

	@Column(name="TO_LICENSE_IF")
	private Long toLicenseIf;

	@Column(name="TO_REMARKS")
	private String toRemarks;

	@Column(name="TO_USER")
	private String toUser;

	@Column(name="TRANS_ID")
	private BigDecimal transId;

	@Column(name="TRANS_IF")
	private BigDecimal transIf;

	@Column(name="TRANS_NAME")
	private String transName;

	@Column(name="TRANS_NO")
	private String transNo;

	@Column(name="U_STATUS")
	private String uStatus;

	@Column(name="USER_ID")
	private Long userId;

	@Column(name="USER_REMARKS")
	private String userRemarks;

	@Temporal(TemporalType.DATE)
	@Column(name="USER_RETURN_DATE")
	private Date userReturnDate;

	@Column(name="USER_STATUS")
	private BigDecimal userStatus;



}