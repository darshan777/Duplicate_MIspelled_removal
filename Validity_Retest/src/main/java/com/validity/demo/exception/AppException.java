package com.validity.demo.exception;

public class AppException extends RuntimeException {

    public AppException(String errorMessage) {
        super(errorMessage);
    }
}
