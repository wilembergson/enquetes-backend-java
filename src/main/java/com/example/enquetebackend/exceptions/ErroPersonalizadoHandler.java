package com.example.enquetebackend.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErroPersonalizadoHandler {
    @ExceptionHandler(ErroPadrao.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ErroPadrao ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.messageError());
    }
}