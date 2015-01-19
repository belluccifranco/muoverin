package com.muoverin.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorFormInfo handleMethodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException ex) {
        return buildErrorFormInfo(req, ex.getBindingResult());
    }

    @ExceptionHandler(BusinessValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorFormInfo handleBusinessValidation(HttpServletRequest req, BusinessValidationException ex) {
        return buildErrorFormInfo(req, ex.getBindingResult());
    }

    public ErrorFormInfo buildErrorFormInfo(HttpServletRequest req, BindingResult result) {
        String errorMessage = localizeErrorMessage("message-errorGeneralInfo");
        String errorURL = req.getRequestURL().toString();
        ErrorFormInfo errorFormInfo = new ErrorFormInfo(errorURL, errorMessage, result.getObjectName());        
        List<FieldError> fieldErrors = result.getFieldErrors();
        errorFormInfo.getFieldErrors().addAll(populateFieldErrors(fieldErrors));
        return errorFormInfo;
    }

    public List<FieldErrorDTO> populateFieldErrors(List<FieldError> fieldErrorList) {
        List<FieldErrorDTO> fieldErrors = new ArrayList<>();
        StringBuilder errorMessage = new StringBuilder("");        

        for (FieldError fieldError : fieldErrorList) {
            String formattedField;
            errorMessage.append(fieldError.getCode()).append("-");
            errorMessage.append(fieldError.getObjectName()).append("-");
            formattedField = fieldError.getField().replace(".", "-");
            errorMessage.append(formattedField);            
            String localizedErrorMsg = localizeErrorMessage(errorMessage.toString());
            fieldErrors.add(new FieldErrorDTO(formattedField, localizedErrorMsg));
            errorMessage.delete(0, errorMessage.capacity());
        }        
        return fieldErrors;
    }

    public String localizeErrorMessage(String errorCode) {
        Locale locale = LocaleContextHolder.getLocale();
        String errorMessage = messageSource.getMessage(errorCode, null, locale);
        return errorMessage;
    }
}
