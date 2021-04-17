package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name="lastname")
    private String lastname;

    @Column(name="surname")
    private String surname;

    @Column(name="dayOfBirth")
    private String dayOfBirth;

    @Column(name="passportNumber")
    private String passportNumber;

    @Column(name="address")
    private String address;

    @Column(name="password")
    private String password;
}
