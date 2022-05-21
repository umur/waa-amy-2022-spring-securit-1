package com.example.springsecuritybackend.aspect.exceptions;

public class AopIsAwesomeHeaderException extends Exception{
    private String message;

    public AopIsAwesomeHeaderException(String message) {
        super(message);
        this.message = message;
    }
}
