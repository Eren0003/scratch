package com.example.springbootjdbc.exception;

import lombok.Data;

@Data
public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(){}

    public IdNotFoundException(String message){
        super(message);
    }
}