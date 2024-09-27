package com.java.travel_cross_platform_be.Controller;

import com.java.travel_cross_platform_be.DTOs.BaseResponse;
import com.java.travel_cross_platform_be.Exception.UserAlreadyExistsException;
import com.java.travel_cross_platform_be.Exception.UserInvalidException;
import com.java.travel_cross_platform_be.Exception.UserNotFoundException;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<BaseResponse<String>> handleUserNotFound(UserNotFoundException ex) {
        BaseResponse<String> response = new BaseResponse<>(ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<BaseResponse<String>> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        BaseResponse<String> response = new BaseResponse<>(ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<BaseResponse<String>> handleMessagingException(MessagingException ex) {
        BaseResponse<String> response = new BaseResponse<>("An error occurred while sending the email: " + ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(UserInvalidException.class)
    public ResponseEntity<BaseResponse<String>> handleUserInvalidException(UserInvalidException ex) {
        BaseResponse<String> response = new BaseResponse<>(ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        BaseResponse<Map<String, String>> response = new BaseResponse<>("Validation failed", errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<String>> handleGenericException(Exception ex) {
        BaseResponse<String> response = new BaseResponse<>("An unexpected error occurred.", null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}