package com.example.serviceImpl;

import com.example.entity.RegisterEntity;
import lombok.extern.slf4j.Slf4j;
import com.example.model.RegisterRequest;
import org.springframework.stereotype.Service;
import com.example.repository.RegisterRepository;
import com.example.service.RegisterService;

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
