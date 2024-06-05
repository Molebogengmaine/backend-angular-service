package com.example.service;

import com.example.dtos.LoginRequest;
import com.example.dtos.RegisterRequest;
import com.example.dtos.RegisterResponse;

public interface RegisterService {

    RegisterResponse registerUser (RegisterRequest registerRequest);
    RegisterResponse loginUser(LoginRequest loginRequest);
}
