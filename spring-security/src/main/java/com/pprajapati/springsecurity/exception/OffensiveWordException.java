package com.pprajapati.springsecurity.exception;

public class OffensiveWordException extends RuntimeException {
  public  OffensiveWordException(String message) {
    super(message);
  }
}
