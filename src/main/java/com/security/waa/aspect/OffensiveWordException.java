package com.security.waa.aspect;

public class OffensiveWordException extends RuntimeException {
    public OffensiveWordException(String message) {
        super(message);
    }
}
