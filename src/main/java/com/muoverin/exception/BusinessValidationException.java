package com.muoverin.exception;

import org.springframework.validation.BindingResult;

public class BusinessValidationException extends RuntimeException {

    private BindingResult bindingResult;

    public BusinessValidationException() {
        super();
    }

    public BusinessValidationException(BindingResult bindingResult) {
        super();
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

}
