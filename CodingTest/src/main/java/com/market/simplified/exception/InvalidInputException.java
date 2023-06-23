package com.market.simplified.exception;

public class InvalidInputException extends RuntimeException{

    private String message;

    public InvalidInputException(){}

    public InvalidInputException(String msg) {
        super(msg);
        this.message = msg;
    }
}