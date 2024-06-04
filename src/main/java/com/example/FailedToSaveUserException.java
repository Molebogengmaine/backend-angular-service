package com.example;


public class FailedToSaveUserException extends RuntimeException {
    public FailedToSaveUserException(String errorMessage) {
        super(errorMessage);
    }
}
