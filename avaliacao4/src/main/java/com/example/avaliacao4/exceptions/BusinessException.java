package com.example.avaliacao4.exceptions;


public class BusinessException extends RuntimeException {

    private Integer status;

    private String error;

    private String message;

    public BusinessException(Integer status, String error, String message) {
        super();
        this.status = status;
        this.error = error;
        this.message = message;
    }
    public BusinessException(){}

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
