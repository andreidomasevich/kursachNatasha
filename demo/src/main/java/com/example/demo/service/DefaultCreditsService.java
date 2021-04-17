package com.example.demo.service;

import com.example.demo.dto.CreditsDto;
import com.example.demo.dto.CreditsList;
import com.example.demo.dto.UsersList;
import com.example.demo.entity.Credits;
import com.example.demo.entity.Users;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.CreditsRepository;
import com.example.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultCreditsService implements CreditsService{
    private final CreditsRepository creditsRepository;
    private final UsersRepository usersRepository;
    private final CreditsConverter creditsConverter;
    private final UsersConverter usersConverter;


    @Override
    public CreditsDto saveCredit(CreditsDto creditsDto) throws ValidationException {
        validateUserDto(creditsDto);
        Credits savedCredit = creditsRepository.save(creditsConverter.fromCreditsDtoToCredits(creditsDto));
        return creditsConverter.fromCreditsToCreditsDto(savedCredit);
    }


    @Override
    public CreditsList findAllByUserId(Integer userId) {
        CreditsList creditsList = new CreditsList();
        Users users = new Users();
        users.setId(userId);
        creditsList.userCredits = creditsRepository.findAllByUserId(users).stream()
                .map(creditsConverter::fromCreditsToCreditsDto)
                .collect(Collectors.toList());
        return creditsList;
    }

    @Override
    public CreditsList findAll() {
        CreditsList creditsList = new CreditsList();
        creditsList.userCredits = creditsRepository.findAll()
                .stream()
                .map(creditsConverter::fromCreditsToCreditsDto)
                .collect(Collectors.toList());
        return creditsList;
    }

    @Override
    public void deleteCredit(Integer creditId) {
        creditsRepository.deleteById(creditId);
    }

    private void validateUserDto(CreditsDto creditsDto) throws ValidationException {
        if (isNull(creditsDto)) {
            throw new ValidationException("Object user is null");
        }
    }



}
