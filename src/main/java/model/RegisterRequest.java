package model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class RegisterRequest {

    private String name;
    private String lastName;
    private String phoneNumbers;
    private String emailAddress;
}
