package com.ms.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(UserAlreadyExists ex) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(ex.getMessage(), LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.toString(),
                "USER_ALREADY_EXISTS",
                "/api/v1/user");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponseDto);
    }
}