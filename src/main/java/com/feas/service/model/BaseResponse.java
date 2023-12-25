package com.feas.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;

public class BaseResponse<T> {

    private String responseMessage;
    private Timestamp serverUTCTime;
    private T businessResponse;

    public BaseResponse(T businessResponse, String responseMessage) {
        this.businessResponse = businessResponse;
        this.responseMessage = responseMessage;
        this.serverUTCTime = new Timestamp(System.currentTimeMillis());
    }

    public BaseResponse(String responseMessage) {
        this.businessResponse = null;
        this.responseMessage = responseMessage;
        this.serverUTCTime = new Timestamp(System.currentTimeMillis());
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public T getBusinessResponse() {
        return businessResponse;
    }

    public void setBusinessResponse(T businessResponse) {
        this.businessResponse = businessResponse;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Timestamp getServerUTCTime() {
        return serverUTCTime;
    }

    public void setServerUTCTime(Timestamp serverUTCTime) {
        this.serverUTCTime = serverUTCTime;
    }
}
