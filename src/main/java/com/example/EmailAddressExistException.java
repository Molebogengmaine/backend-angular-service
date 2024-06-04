package com.example;


public class EmailAddressExistException extends RuntimeException {
    public EmailAddressExistException(String errorMessage) {
        super(errorMessage);
    }
}
