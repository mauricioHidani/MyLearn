package com.challenge.clients.crud.controllers.handlers;

import com.challenge.clients.crud.dtos.FieldErrorMessage;
import com.challenge.clients.crud.dtos.FieldValidationException;
import com.challenge.clients.crud.dtos.ResponseException;
import com.challenge.clients.crud.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseException> resourceNotFound(ResourceNotFoundException e, HttpServletRequest req) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ResponseException res = ResponseException
            .builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error(e.getMessage())
                .path(req.getRequestURI())
            .build();
        return ResponseEntity.status(status).body(res);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseException> fieldValidation(MethodArgumentNotValidException e,
                                                             HttpServletRequest req) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        FieldValidationException res = FieldValidationException
            .builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error("Dados inválidos")
                .path(req.getRequestURI())
            .build();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            res.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(res);
    }
}
