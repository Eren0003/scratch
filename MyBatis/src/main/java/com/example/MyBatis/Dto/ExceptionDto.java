package com.example.MyBatis.Dto;

import ch.qos.logback.core.spi.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDto {
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;
}
