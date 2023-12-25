package com.feas.service.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;

public class UserDataPOJO {

	private Long patientId;
	private String patientNo;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String userName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mobileNo;
	private String firstName;
	private String lastName;
	private String idCard;
	private String password;
	private Timestamp dateOfBirth;
	private String userImageUrl;
	private String nationality;
	private String insuranceCardNo;
	private Timestamp insuranceCardExpDate;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private FamilyMemberRelationEnum familyMemberRelation;
	
	private String picPath;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUserImageUrl() {
		return userImageUrl;
	}

	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getInsuranceCardNo() {
		return insuranceCardNo;
	}

	public void setInsuranceCardNo(String insuranceCardNo) {
		this.insuranceCardNo = insuranceCardNo;
	}

	public Timestamp getInsuranceCardExpDate() {
		return insuranceCardExpDate;
	}

	public void setInsuranceCardExpDate(Timestamp insuranceCardExpDate) {
		this.insuranceCardExpDate = insuranceCardExpDate;
	}

	public FamilyMemberRelationEnum getFamilyMemberRelation() {
		return familyMemberRelation;
	}

	public void setFamilyMemberRelation(FamilyMemberRelationEnum familyMemberRelation) {
		this.familyMemberRelation = familyMemberRelation;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

}
