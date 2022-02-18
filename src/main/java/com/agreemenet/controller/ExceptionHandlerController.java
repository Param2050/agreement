package com.agreemenet.controller;

import com.agreemenet.exceptions.ValidationException;
import com.agreemenet.utils.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity handleValidationException(ValidationException ex,
                                                          WebRequest request) {
        ResponseData responseData = new ResponseData(false, ex.getMessage(), 400, null);
        return new ResponseEntity<>(responseData, HttpStatus.BAD_REQUEST);
    }
}
