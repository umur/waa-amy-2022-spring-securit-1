package com.example.lab4.exceptions;

public class RequestBannedException extends RuntimeException{
    public RequestBannedException(String message){
        super(message);
    }
}
