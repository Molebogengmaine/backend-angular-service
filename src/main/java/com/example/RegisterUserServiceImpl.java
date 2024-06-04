package com.example;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class RegisterUserServiceImpl implements RegisterService {
    private RegisterRepository registerRepository;

    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {

        var validatePhoneNumbers = registerRequest.getPhoneNumber();
        try {

                RegisterEntity registerEntity = new RegisterEntity();
                registerEntity.setUsername(registerRequest.getCustomerName());
                registerEntity.setLastName(registerRequest.getLastName());
                registerEntity.setEmailAddress(registerRequest.getEmailAddress());
                registerEntity.setPhoneNumber(registerRequest.getPhoneNumber());
                registerEntity.setPassword(registerRequest.getPassword());
            if (validatePhoneNumbers.length() == 10) {
              var savedUser=  registerRepository.save(registerEntity);
                log.info("Profile was created successfully:{}",savedUser.getUsername());
            }else{
                throw new PhoneNumberException("Phone numbers must be 10 digits");
            }

        } catch (Exception e) {
            throw new PhoneNumberException("Phone numbers must be 10 digits");
        }
        return RegisterResponse.builder()
                .message("User registered successfully")
                .statusCode(HttpStatus.CREATED.value())
                .success(true).build();
    }
}
