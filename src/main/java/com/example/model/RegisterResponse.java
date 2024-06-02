package com.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter

public class RegisterResponse implements Serializable {

    private  String message;
    private  int statusCode;
    private boolean success;
}
