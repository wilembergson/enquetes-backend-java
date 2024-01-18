package com.example.enquetebackend.exceptions;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ErroPersonalizadoHandler {
    @ExceptionHandler(ErroPadrao.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ErroPadrao ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.messageError());
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<Object> handleTokenExpiredException(JWTVerificationException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("mensagem", ex.getMessage()));
    }
}