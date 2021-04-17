package com.example.demo.service;

import com.example.demo.dto.UsersDto;
import com.example.demo.dto.UsersList;
import com.example.demo.entity.Users;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUsersService implements UsersService{
    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;


    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
        Optional<Users> usersById = Optional.ofNullable(usersRepository.findByLogin(usersDto.getLogin()));
        if (usersById.isPresent()) {
            throw new ValidationException("User exists");
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = usersRepository.findByLogin(login);
        if (users != null) {
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
    }

    @Override
    public UsersDto findById(Integer userId) {
        Users users = usersRepository.findById(userId).orElse(null);
        if (users != null) {
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
    }

    @Override
    public UsersList findAll() {
        UsersList usersList = new UsersList();
        usersList.userList = usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
        return usersList;
    }
}
