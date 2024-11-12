package com.chat.chat.response;

public class ApiResponse {
    private String message;
    private boolean Status;
    

    public ApiResponse() {
    }
    public ApiResponse(String message, boolean status) {
        this.message = message;
        Status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isStatus() {
        return Status;
    }
    public void setStatus(boolean status) {
        Status = status;
    }
    
}
