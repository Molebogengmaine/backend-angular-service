package com.example.controller;

import com.example.dtos.LoginRequest;
import com.example.dtos.RegisterRequest;
import com.example.dtos.RegisterResponse;
import com.example.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
  public class RegisterController  {

    private final RegisterService registerService;
@Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping(value = "/register-user",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterResponse>  registerNewUser (RegisterRequest request) {

        return ResponseEntity.ok(registerService.registerUser(request));

    }
    @PostMapping(value = "/login-user",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterResponse> loginUser(LoginRequest loginRequest){
    return  ResponseEntity.ok(registerService.loginUser(loginRequest));
    }
}
