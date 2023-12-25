package com.feas.persistence.specification.filter;


import com.feas.persistence.specification.enums.Operation;

public class Filter {
    private String key;
    private Operation operation;
    private String value;

    public Filter() {
    }

    public Filter(String key, Operation operation, String value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
