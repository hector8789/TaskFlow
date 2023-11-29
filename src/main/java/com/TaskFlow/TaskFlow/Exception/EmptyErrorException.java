package com.TaskFlow.TaskFlow.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class EmptyErrorException extends RuntimeException {

    private String code;
    private HttpStatus status;
    private BindingResult results;

    public EmptyErrorException(String message) {
        super(message);
    }

    public EmptyErrorException(String message, String code, HttpStatus status, BindingResult results) {
        super(message);

        this.code = code;
        this.status = status;
        this.results = results;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public BindingResult getResults() {
        return results;
    }

    public void setResults(BindingResult results) {
        this.results = results;
    }
}
