package com.feas.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import jakarta.persistence.*;


/**
 * The persistent class for the WF_USERS database table.
 * 
 */
@Entity
@Table(name = "WF_USERS")
public class WfUsers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID")
	private long userId;

	private String aname;

	@Column(name = "DEPT_IF")
	private BigDecimal deptIf;

	@Column(name = "DESIG_IF")
	private BigDecimal desigIf;

	private String ename;

	@Column(name = "ENCRYPT_KEY")
	private String encryptKey;

	@Column(name = "FING_NAME")
	private String fingName;

	@Lob
	private byte[] finger;

	@Column(name = "FP_USERS")
	private String fpUsers;

	@Column(name = "INSERT_BY")
	private String insertBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "INSERT_DATE")
	private Date insertDate;

	@Column(name = "LOGIN_MOD")
	private String loginMod;

	@Column(name = "LOGIN_NAME")
	private String loginName;

	@Column(name = "ORDER_BY")
	private BigDecimal orderBy;

	@Column(name = "ROLE_IF")
	private BigDecimal roleIf;

	@Column(name = "SHOW_YN")
	private String showYn;

	@Column(name = "UPDATE_BY")
	private String updateBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@Column(name = "USER_ARCHEIVE")
	private BigDecimal userArcheive;

	@Column(name = "USER_LEVEL")
	private BigDecimal userLevel;

	@Column(name = "USER_NO")
	private String userNo;

	@Column(name = "USER_PASS")
	private String userPass;

	@Temporal(TemporalType.DATE)
	@Column(name = "USER_PASS_CHANGE_DT")
	private Date userPassChangeDt;

	@Column(name = "USER_PWD")
	private String userPwd;

	@Column(name = "MANAGER_IF")
	private BigDecimal managerIf;


	  //bi-directional many-to-one association to WfUser
//	  
//	  @OneToMany(mappedBy="wfUser",fetch = FetchType.LAZY)
//	  private List<WfUsers> wfUsers;
	  
	 

	@Transient
	private boolean deleteF;

	public boolean isDeleteF() {
		return deleteF;
	}

	public void setDeleteF(boolean deleteF) {
		this.deleteF = deleteF;
	}

	public WfUsers() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public BigDecimal getDeptIf() {
		return this.deptIf;
	}

	public void setDeptIf(BigDecimal deptIf) {
		this.deptIf = deptIf;
	}

	public BigDecimal getDesigIf() {
		return this.desigIf;
	}

	public void setDesigIf(BigDecimal desigIf) {
		this.desigIf = desigIf;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEncryptKey() {
		return this.encryptKey;
	}

	public void setEncryptKey(String encryptKey) {
		this.encryptKey = encryptKey;
	}

	public String getFingName() {
		return this.fingName;
	}

	public void setFingName(String fingName) {
		this.fingName = fingName;
	}

	public byte[] getFinger() {
		return this.finger;
	}

	public void setFinger(byte[] finger) {
		this.finger = finger;
	}

	public String getFpUsers() {
		return this.fpUsers;
	}

	public void setFpUsers(String fpUsers) {
		this.fpUsers = fpUsers;
	}

	public String getInsertBy() {
		return this.insertBy;
	}

	public void setInsertBy(String insertBy) {
		this.insertBy = insertBy;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getLoginMod() {
		return this.loginMod;
	}

	public void setLoginMod(String loginMod) {
		this.loginMod = loginMod;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public BigDecimal getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(BigDecimal orderBy) {
		this.orderBy = orderBy;
	}

	public BigDecimal getRoleIf() {
		return this.roleIf;
	}

	public void setRoleIf(BigDecimal roleIf) {
		this.roleIf = roleIf;
	}

	public String getShowYn() {
		return this.showYn;
	}

	public void setShowYn(String showYn) {
		this.showYn = showYn;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public BigDecimal getUserArcheive() {
		return this.userArcheive;
	}

	public void setUserArcheive(BigDecimal userArcheive) {
		this.userArcheive = userArcheive;
	}

	public BigDecimal getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(BigDecimal userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserNo() {
		return this.userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public Date getUserPassChangeDt() {
		return this.userPassChangeDt;
	}

	public void setUserPassChangeDt(Date userPassChangeDt) {
		this.userPassChangeDt = userPassChangeDt;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

		

	public BigDecimal getManagerIf() {
		return managerIf;
	}

	public void setManagerIf(BigDecimal managerIf) {
		this.managerIf = managerIf;
	}

	@Override
	public String toString() {
		return "WfUsers [userId=" + userId + ", aname=" + aname + ", deptIf=" + deptIf + ", desigIf=" + desigIf
				+ ", ename=" + ename + ", encryptKey=" + encryptKey + ", fingName=" + fingName + ", finger="
				+ Arrays.toString(finger) + ", fpUsers=" + fpUsers + ", insertBy=" + insertBy + ", insertDate="
				+ insertDate + ", loginMod=" + loginMod + ", loginName=" + loginName + ", orderBy=" + orderBy
				+ ", roleIf=" + roleIf + ", showYn=" + showYn + ", updateBy=" + updateBy + ", updateDate=" + updateDate
				+ ", userArcheive=" + userArcheive + ", userLevel=" + userLevel + ", userNo=" + userNo + ", userPass="
				+ userPass + ", userPassChangeDt=" + userPassChangeDt + ", userPwd=" + userPwd + ", managerIf="
				+ managerIf + ", deleteF=" + deleteF + "]";
	}



}