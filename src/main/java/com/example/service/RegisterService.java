package com.example.service;

import com.example.entity.RegisterEntity;
import com.example.model.RegisterRequest;

public interface RegisterService {

    RegisterEntity registerUser (RegisterRequest registerRequest);
}
