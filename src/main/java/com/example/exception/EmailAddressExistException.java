package com.example.exception;


public class EmailAddressExistException extends RuntimeException {
    public EmailAddressExistException(String errorMessage) {
        super(errorMessage);
    }
}
