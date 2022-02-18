package com.agreemenet.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Validated
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> implements Serializable {
    private boolean success;
    private String errorMessage;
    private int statusCode;
    private T result;

    public ResponseData(boolean success, String errorMessage, int statusCode, T result) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.result = result;
    }

    public ResponseData(T result) {
        this.result = result;
        this.success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                ", statusCode=" + statusCode +
                ", result=" + result +
                '}';
    }

}
