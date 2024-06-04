package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<RegisterResponse>  registerNewUser ( RegisterRequest request) {

        return ResponseEntity.ok(registerService.registerUser(request));

    }
}
