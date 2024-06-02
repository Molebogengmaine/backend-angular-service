package service;

import model.RegisterRequest;
import model.RegisterResponse;

public interface RegisterService {

    RegisterResponse registerUser (RegisterRequest registerRequest);
}
