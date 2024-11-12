package com.chat.chat.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> otherException(Exception ex,WebRequest req){

        ErrorDetails errors=new ErrorDetails(ex.getMessage(),req.getDescription(false), LocalDateTime.now());
        
        return new ResponseEntity<ErrorDetails>(errors,HttpStatus.BAD_REQUEST);

    }
    
}
