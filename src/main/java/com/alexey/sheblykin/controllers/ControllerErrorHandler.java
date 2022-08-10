package com.alexey.sheblykin.controllers;

import io.swagger.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ControllerErrorHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity<ErrorModel> entityNotFound() {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode(status.value());
        errorModel.setMessage("Entity with specified id not found");
        return new ResponseEntity<>(errorModel, status);
    }

    @ExceptionHandler(value = {
            HttpMessageNotReadableException.class,
            NumberFormatException.class
    })
    protected ResponseEntity<ErrorModel> badRequest() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode(status.value());
        errorModel.setMessage("Bad request, check provided arguments");
        return new ResponseEntity<>(errorModel, status);
    }
}
