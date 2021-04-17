package com.example.demo.dto;

import com.example.demo.entity.Credits;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsersDto {
    private Integer id;
    private String name;
    private String lastname;
    private String surname;
    private String dayOfBirth;
    private String passportNumber;
    private String address;
    private String login;
    private String email;
    private String password;
}
