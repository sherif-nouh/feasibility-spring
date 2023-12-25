package com.feas.service.model.lookup;

public class LookupResponsePOJO {

    private Long id;
    private String textValue;

    public LookupResponsePOJO(Long id, String textValue) {
        this.id = id;
        this.textValue = textValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

}
