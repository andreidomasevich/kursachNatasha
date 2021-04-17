package com.example.demo.service;

import com.example.demo.dto.CreditsDto;
import com.example.demo.dto.CreditsList;
import com.example.demo.dto.DepositsDto;
import com.example.demo.dto.DepositsList;
import com.example.demo.exception.ValidationException;

import java.util.List;

public interface DepositsService {
    DepositsDto saveDeposit(DepositsDto depositsDto) throws ValidationException;

    DepositsList findAllByUserId(Integer userId);

    DepositsList findAll();

    void deleteDeposit(Integer creditId);
}
