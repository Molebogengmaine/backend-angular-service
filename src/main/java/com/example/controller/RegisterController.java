package com.example.controller;

import com.example.entity.RegisterEntity;
import lombok.extern.slf4j.Slf4j;
import com.example.model.RegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.serviceImpl.RegisterUserServiceImpl;

@RestController
@Slf4j
public class RegisterController  {

    private RegisterUserServiceImpl registerService;

    @PostMapping("/register-user")
    public RegisterEntity registerNewUser (RegisterRequest request){

       var response = registerService.registerUser(request);
        return response;
    }

}
