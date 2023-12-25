package com.feas.service.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoginResponsePOJO {

    @JsonIgnore
    private String failureCode;
    private String jwtToken;
    private UserDataPOJO userDataPOJO;

    public LoginResponsePOJO(String jwtToken, UserDataPOJO userDataPOJO) {
        this.jwtToken = jwtToken;
        this.userDataPOJO = userDataPOJO;
    }

    public LoginResponsePOJO(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public UserDataPOJO getUserDataPOJO() {
        return userDataPOJO;
    }

    public void setUserDataPOJO(UserDataPOJO userDataPOJO) {
        this.userDataPOJO = userDataPOJO;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

}
