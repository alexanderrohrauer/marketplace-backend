package com.example.marketplacebackend.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

public class ErrorResponse {
    private final String message;
    private final Integer status;
    private final Instant timestamp;

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();
        this.timestamp = Instant.now();
    }

    public static ResponseEntity<ErrorResponse> of(String message, HttpStatus status) {
        return ResponseEntity.status(status).body(new ErrorResponse(message, status));
    }
}
