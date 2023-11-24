package com.example.MyBatis;

import com.example.MyBatis.Dto.ExceptionDto;
import com.example.MyBatis.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDto> exception (UserNotFoundException e){
        ExceptionDto exception = ExceptionDto.builder()
                .message("username Not Found !")
                .httpStatus(HttpStatus.BAD_REQUEST)
                .timestamp(ZonedDateTime.now()).build();
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
