package com.learning.elevate_ed.elevate_ed.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ElevateEdException extends Exception{

    String message;
    HttpStatus statusCode;

    public ElevateEdException(String message, HttpStatus statusCode) {
        this.message  = message;
        this.statusCode = statusCode;
    }
}
