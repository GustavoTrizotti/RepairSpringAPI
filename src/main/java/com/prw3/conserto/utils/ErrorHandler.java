package com.prw3.conserto.utils;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleBadRequestException(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        var errorDtoList = errors.stream()
                .map(BadRequestValidationDTO::new)
                .toList();
        return ResponseEntity.badRequest().body(errorDtoList);
    }

    private record BadRequestValidationDTO(String field, String errorMessage) {
        public BadRequestValidationDTO(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
