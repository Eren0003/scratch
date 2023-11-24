package com.example.ExceptionHandling.Advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ControllerAdvice
public class ResourceNotFoundException extends RuntimeException{
    private int errorCode;
    private String errorMessage;
    private static final long serialVersionUID = 1L;

}
