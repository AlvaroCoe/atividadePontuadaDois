package com.example.atividadePontuadaDois.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalException {

    // 1. Erro de Requisição (400 - Bad Request)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgument(IllegalArgumentException e, HttpServletRequest request) {
        String error = "Atributo Inválido";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    // 2. Recurso não encontrado (404 - Not Found)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    // 3. Erro de Duplicidade (409 - Conflict ou 400 - Bad Request) add posteriormente
    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrity(org.springframework.dao.DataIntegrityViolationException e, HttpServletRequest request) {
        String error = "Conflito de Dados";
        // Usamos 409 Conflict porque o recurso (email/login) já existe
        HttpStatus status = HttpStatus.CONFLICT;

        String message = "Código de acesso já cadastrado no sistema.";

        StandardError err = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    // 4.
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationError(
            org.springframework.web.bind.MethodArgumentNotValidException e,
            HttpServletRequest request) {
        String error = "Erro de validação";
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        String message = e.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(f -> f.getDefaultMessage())
                .orElse("Erro de validação nos campos enviados");
        StandardError err = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    // 5.
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandardError> runtimeError(RuntimeException e, HttpServletRequest request) {
        String error = "Erro de Processamento Interno";
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
