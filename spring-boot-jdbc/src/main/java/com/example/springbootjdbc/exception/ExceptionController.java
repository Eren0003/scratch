package com.example.springbootjdbc.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ExceptionDto> exceptionHandler(IdNotFoundException e){
        List<String> string = new ArrayList<>();
        string.add(e.getMessage());
        ExceptionDto dto = new ExceptionDto(
                string,
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST
                );
        return new  ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto>valid(MethodArgumentNotValidException e){
        List<String> string = e.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        System.out.println(string);
        ExceptionDto dto = new ExceptionDto(
                string,
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<ExceptionDto>validation(HttpMessageConversionException e){
        List<String> string = new ArrayList<>();
        string.add(e.getMessage());
        ExceptionDto dto = new ExceptionDto(
                string,
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
    }
}
