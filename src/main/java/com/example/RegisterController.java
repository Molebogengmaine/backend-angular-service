package com.example;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@Controller
public class RegisterController  {

    private RegisterUserServiceImpl registerService;

    @PostMapping("/register-user")
    public RegisterEntity registerNewUser (RegisterRequest request){

       var response = registerService.registerUser(request);
        return response;
    }

}
