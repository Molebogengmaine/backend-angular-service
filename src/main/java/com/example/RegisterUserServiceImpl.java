package com.example;

import com.example.RegisterEntity;
import lombok.extern.slf4j.Slf4j;
import com.example.RegisterRequest;
import org.springframework.stereotype.Service;
import com.example.RegisterRepository;
import com.example.RegisterService;

@Service
@Slf4j
public class RegisterUserServiceImpl implements RegisterService {

    private RegisterRepository registerRepository;

    @Override
    public RegisterEntity registerUser(RegisterRequest registerRequest) {

        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setCustomerName(registerRequest.getCustomerName());
        registerEntity.setLastName(registerRequest.getLastName());
        registerEntity.setEmailAddress(registerRequest.getEmailAddress());
        registerEntity.setPhoneNumber(registerRequest.getPhoneNumbers());
           var response = registerRepository.save(registerEntity);

        return response;
        // }
    }
}
