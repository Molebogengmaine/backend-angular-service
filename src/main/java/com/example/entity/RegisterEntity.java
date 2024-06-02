package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "phoneNumber")
    private  int phoneNumber;
    @Column(name = "customerName")//mapping a specific column
    private  String customerName;
    @Column(name = "lastName")
    private  String lastName;
    @Column(name = "emailAddress")
    private  String emailAddress;
}
