package com.example.demo.service;

import com.example.demo.dto.CreditsDto;
import com.example.demo.dto.CreditsList;
import com.example.demo.exception.ValidationException;

import java.util.List;


public interface CreditsService {
    CreditsDto saveCredit(CreditsDto creditsDto) throws ValidationException;

    CreditsList findAllByUserId(Integer userId);

    CreditsList findAll();

    void deleteCredit(Integer creditId);
}
