package com.example.serviceImpl;

import com.example.dtos.LoginRequest;
import com.example.dtos.RegisterRequest;
import com.example.dtos.RegisterResponse;
import com.example.enity.RegisterEntity;
import com.example.exception.EmailAddressExistException;
import com.example.exception.FailedToSaveUserException;
import com.example.exception.PhoneNumberException;
import com.example.repository.RegisterRepository;
import com.example.service.RegisterService;
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
            if (validatePhoneNumbers.length() != 10) {
                throw new PhoneNumberException("Phone numbers must be 10 digits");
            }
            Optional<RegisterEntity> emailExist = registerRepository.findByEmailAddress(registerRequest.getEmailAddress());
            if (emailExist.isPresent()) {
                throw new EmailAddressExistException("A user with this email address already exist");
            }
            RegisterEntity registerEntity = new RegisterEntity();
            registerEntity.setUsername(registerRequest.getCustomerName());
            registerEntity.setLastName(registerRequest.getLastName());
            registerEntity.setEmailAddress(registerRequest.getEmailAddress());
            registerEntity.setPhoneNumber(registerRequest.getPhoneNumber());
            registerEntity.setPassword(registerRequest.getPassword());
            registerEntity.setCreatedDate(formatDateTime);
            var savedUser = registerRepository.save(registerEntity);
            log.info("{} Registered successfully:", savedUser.getUsername());

        } catch (FailedToSaveUserException e) {
            throw new FailedToSaveUserException("Failed to register user successfully");
        } catch (PhoneNumberException e) {
            throw new PhoneNumberException("Phone numbers must be 10 digits");
        }

        return RegisterResponse.builder()
                .message("User registered successfully")
                .statusCode(HttpStatus.CREATED.value())
                .success(true).build();
    }

    @Override
    public RegisterResponse loginUser(LoginRequest loginRequest) {
        try {
            Optional<RegisterEntity> loggedInUser = registerRepository.findByEmailAddress(loginRequest.getEmailAddress());
            if (loggedInUser.isPresent()) {
                var currentLoggedInUser = loggedInUser.get();
                log.info("Logged in {} session:", currentLoggedInUser.getEmailAddress());
            }else {
                throw  new EmailAddressExistException("Username does not exist please sign up");
            }

            return RegisterResponse.builder()
                    .message("User Logged in successfully")
                    .statusCode(HttpStatus.OK.value())
                    .success(true).build();
        } catch (EmailAddressExistException e) {
            throw  new EmailAddressExistException("Username does not exist please sign up");
        }
    }
}
