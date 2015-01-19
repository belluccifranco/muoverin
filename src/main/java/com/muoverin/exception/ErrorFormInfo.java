package com.muoverin.exception;

import java.util.ArrayList;
import java.util.List;

public class ErrorFormInfo {

    private String url;
    private String message;
    private String objectName;
    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public ErrorFormInfo() {
    }

    public ErrorFormInfo(String url, String message, String objectName) {
        this.url = url;
        this.message = message;
        this.objectName = objectName;
    }

    public ErrorFormInfo(List<FieldErrorDTO> fieldErrors, String url, String message) {
        this.fieldErrors = fieldErrors;
        this.url = url;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
