package com.example.dtos;



import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest implements  Serializable {

    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String customerName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String emailAddress;
    @NotBlank
    private String password;
}
