package com.market.simplified.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.market.simplified.entity.Excep;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Excep> handleResurceNotFoundExcep(ResourceNotFoundException e){
        Excep excep = new Excep(e.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(excep,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidInputException.class)
    public ResponseEntity<Excep> handleInvalidInputExcep(InvalidInputException ie){
        Excep excep = new Excep(ie.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(excep,HttpStatus.NOT_FOUND);
    }

}
