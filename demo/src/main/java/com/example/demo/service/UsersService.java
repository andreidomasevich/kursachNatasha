package com.example.demo.service;

import com.example.demo.dto.UsersDto;
import com.example.demo.dto.UsersList;
import com.example.demo.exception.ValidationException;

import java.util.List;

public interface UsersService {
    UsersDto saveUser(UsersDto usersDto) throws ValidationException;

    void deleteUser(Integer userId);

    UsersDto findByLogin(String login);

    UsersDto findById(Integer userId);

    UsersList findAll();
}
