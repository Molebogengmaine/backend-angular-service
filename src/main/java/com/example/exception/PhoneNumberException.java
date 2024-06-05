package com.example.exception;


public class PhoneNumberException extends RuntimeException {
    public PhoneNumberException(String errorMessage) {
        super(errorMessage);
    }
}
