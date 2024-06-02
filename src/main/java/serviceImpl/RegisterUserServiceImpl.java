package serviceImpl;

import lombok.extern.slf4j.Slf4j;
import model.RegisterRequest;
import model.RegisterResponse;
import org.springframework.stereotype.Service;
import service.RegisterService;

@Service
@Slf4j
public class RegisterUserServiceImpl implements RegisterService {

    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        return null;
    }
}
