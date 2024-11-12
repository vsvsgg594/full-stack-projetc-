package com.chat.chat.Exception;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class ErrorDetails {

    private String message;
    private String errors;
    LocalDateTime localDateTime;
    
    public ErrorDetails(String message, String errors, LocalDateTime localDateTime) {
        this.message = message;
        this.errors = errors;
        this.localDateTime = localDateTime;
    }
    public ErrorDetails() {
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getErrors() {
        return errors;
    }
    public void setErrors(String errors) {
        this.errors = errors;
    }
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
    
    
}
