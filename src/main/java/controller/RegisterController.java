package controller;

import lombok.extern.slf4j.Slf4j;
import model.RegisterRequest;
import model.RegisterResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RegisterService;

@RestController
@Slf4j
public class RegisterController  {

    private RegisterService registerService;

    public RegisterResponse registerNewUser (RegisterRequest request){

        registerService.registerUser(request);
        return null;
    }

}
