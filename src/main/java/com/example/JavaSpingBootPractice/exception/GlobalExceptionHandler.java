package com.example.JavaSpingBootPractice.exception;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException ex, HttpServletRequest request) {
        int status_code = HttpStatus.BAD_REQUEST.value();
        String error_name = "Validation failed";
        Map<String, String> error_message = new HashMap<>();
        String error_path = request.getRequestURI();
        error_message.put("error", ex.getMessage());
        ErrorResponse error_response = new ErrorResponse(status_code, error_name, error_message, error_path);
        return new ResponseEntity<>(error_response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        int status_code = HttpStatus.BAD_REQUEST.value();
        String error_name = "Validation failed";
        Map<String, String> error_message = new HashMap<>();
        String error_path = request.getRequestURI();
        error_message.put("error", ex.getMessage());
        ErrorResponse error_response = new ErrorResponse(status_code, error_name, error_message, error_path);
        return new ResponseEntity<>(error_response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handle_MANVE(MethodArgumentNotValidException ex, HttpServletRequest request) {
        int status_code = HttpStatus.BAD_REQUEST.value();
        String error_name = "Validation failed";
        Map<String, String> error_message = new HashMap<>();
        String error_path = request.getRequestURI();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            error_message.put(error.getField(), error.getDefaultMessage());
        });
        ErrorResponse error_response = new ErrorResponse(status_code, error_name, error_message, error_path);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error_response);
    }
}
