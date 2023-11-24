package com.example.ExceptionHandling.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex){
              ResourceNotFoundException e = ResourceNotFoundException.builder()
                      .errorCode(ex.getErrorCode())
                      .errorMessage(ex.getErrorMessage())
                      .build();
              return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
