package com.example;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class RegisterUserServiceImpl implements RegisterService {
    private RegisterRepository registerRepository;

    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {

        var validatePhoneNumbers = registerRequest.getPhoneNumber();
        try {
            LocalDateTime datetime1 = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formatDateTime = datetime1.format(format);
            if (validatePhoneNumbers.length() == 10) {
                Optional<RegisterEntity> emailExist = registerRepository.findByEmailAddress(registerRequest.getEmailAddress());
                if (emailExist.isEmpty()) {
                    RegisterEntity registerEntity = new RegisterEntity();
                    registerEntity.setUsername(registerRequest.getCustomerName());
                    registerEntity.setLastName(registerRequest.getLastName());
                    registerEntity.setEmailAddress(registerRequest.getEmailAddress());
                    registerEntity.setPhoneNumber(registerRequest.getPhoneNumber());
                    registerEntity.setPassword(registerRequest.getPassword());
                    registerEntity.setCreatedDate(formatDateTime);

                    var savedUser = registerRepository.save(registerEntity);
                    log.info("Registered successfully:{}", savedUser.getUsername());
                }else{
                    throw  new EmailAddressExistException("A user with this email address already exist");
                }
            }else{
                throw new PhoneNumberException("Phone numbers must be 10 digits");
            }
        } catch (Exception e) {
            throw  new FailedToSaveUserException("Failed to register user successfully");
        }
        return RegisterResponse.builder()
                .message("User registered successfully")
                .statusCode(HttpStatus.CREATED.value())
                .success(true).build();
    }
}
