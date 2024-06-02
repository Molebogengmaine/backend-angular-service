package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class RegisterResponse {

    private  String message;
    private  int statusCode;
    private boolean success;
}
