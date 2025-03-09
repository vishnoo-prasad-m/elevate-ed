package com.learning.elevate_ed.elevate_ed.advice;

import com.learning.elevate_ed.elevate_ed.exception.ElevateEdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice // Applies to all controllers
public class ControllerAdvice {

    @ExceptionHandler(ElevateEdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleResourceNotFound(ElevateEdException ex) {
        return new ResponseEntity<String>(ex.getMessage(), ex.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
