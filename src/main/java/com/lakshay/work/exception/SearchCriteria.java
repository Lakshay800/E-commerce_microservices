package com.lakshay.work.exception;

public class SearchCriteria {

    private String key;
    private String operation;
    private Object value;

    public SearchCriteria(String key, String operation, Object value) {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getOperation() {
        return null;
    }

    public boolean isOrPredicate() {
        return true;

    }

}
