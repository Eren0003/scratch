package com.example.springbootjdbc.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ExceptionDto(List<String> message,
                           LocalDateTime timestamp,
                           HttpStatus status) {
}
