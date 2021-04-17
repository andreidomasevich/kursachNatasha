package com.example.demo.service;

import com.example.demo.dto.CreditsDto;
import com.example.demo.dto.UsersDto;
import com.example.demo.entity.Credits;
import com.example.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Component
public class UsersConverter {

    @Autowired
    private CreditsConverter creditsConverter;

    public Users fromUserDtoToUser(UsersDto usersDto) {
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setEmail(usersDto.getEmail());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        users.setLastname(usersDto.getLastname());
        users.setSurname(usersDto.getSurname());
        users.setPassportNumber(usersDto.getPassportNumber());
        users.setDayOfBirth(usersDto.getDayOfBirth());
        users.setAddress(usersDto.getAddress());
        users.setPassword(usersDto.getPassword());
        return users;
    }

    public UsersDto fromUserToUserDto(Users users) {
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .name(users.getName())
                .lastname(users.getLastname())
                .surname(users.getSurname())
                .passportNumber(users.getPassportNumber())
                .dayOfBirth(users.getDayOfBirth())
                .address(users.getAddress())
                .password(users.getPassword())
                .build();
    }

    private List<CreditsDto> convertListFromCreditsToCreditsDto(List<Credits> list){
        List<CreditsDto> resultList = new ArrayList<>();
        list.forEach(item -> resultList.add(creditsConverter.fromCreditsToCreditsDto(item)));
        return resultList;
    }
}
