package com.example.model;


import lombok.*;

import java.io.Serializable;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest implements  Serializable {

    private String customerName;
    private String lastName;
    private int phoneNumbers;
    private String emailAddress;
}
