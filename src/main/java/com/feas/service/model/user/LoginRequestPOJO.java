package com.feas.service.model.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Login Request DTO for storing a user's credentials.
 */
public class LoginRequestPOJO {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    private String usernameOrEmail;
    @NotNull
    @NotBlank
    @Size(min = 4, max = 100)
    private String password;

    private String mobileNumber;
    private String idNumber;
    private String pinCode;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "LoginRequestPOJO{" +
                "usernameOrEmail='" + usernameOrEmail + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }

}
