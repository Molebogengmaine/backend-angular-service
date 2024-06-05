package com.example.exception;


public class FailedToSaveUserException extends RuntimeException {
    public FailedToSaveUserException(String errorMessage) {
        super(errorMessage);
    }
}
