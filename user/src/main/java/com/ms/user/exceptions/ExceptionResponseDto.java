package com.ms.user.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public record ExceptionResponseDto(
        String message,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime timestamp,
        String status,
        String errorCode,
        String path
) {
}
