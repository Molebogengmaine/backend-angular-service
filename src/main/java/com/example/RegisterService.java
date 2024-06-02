package com.example;

import com.example.RegisterEntity;
import com.example.RegisterRequest;

public interface RegisterService {

    RegisterEntity registerUser (RegisterRequest registerRequest);
}
