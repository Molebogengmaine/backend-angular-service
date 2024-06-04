package com.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor //generate a constructor with no parameters.
@Table(name="register")
public class RegisterEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "phonenumber")
    private  String phoneNumber;
    @Column(name = "username")//mapping a specific column
    private  String username;
    @Column(name = "lastname")
    private  String lastName;
    @Column(name = "emailaddress")
    private  String emailAddress;
    @Column(name = "password")
    private  String password;
}
