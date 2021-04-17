package com.example.demo.service;

import com.example.demo.dto.CreditsList;
import com.example.demo.dto.DepositsDto;
import com.example.demo.dto.DepositsList;
import com.example.demo.entity.Deposits;
import com.example.demo.entity.Users;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.DepositsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultDepositsService implements DepositsService {

        private final DepositsRepository depositsRepository;
        private final DepositsConverter depositsConverter;

        @Override
        public DepositsDto saveDeposit(DepositsDto depositsDto) throws ValidationException {
            validateUserDto(depositsDto);
            Deposits savedDeposit = depositsRepository.save(depositsConverter.fromDepositsDtoToDeposits(depositsDto));
            return depositsConverter.fromDepositsToDepositsDto(savedDeposit);
        }

        @Override
        public DepositsList findAllByUserId(Integer userId) {
            DepositsList depositsList = new DepositsList();
            Users users = new Users();
            users.setId(userId);
            depositsList.userDeposits = depositsRepository.findAllByUserId(users).stream()
                    .map(depositsConverter::fromDepositsToDepositsDto)
                    .collect(Collectors.toList());;
            return depositsList;

        }

    @Override
    public DepositsList findAll() {
        DepositsList depositsList = new DepositsList();
        depositsList.userDeposits = depositsRepository.findAll()
                .stream()
                .map(depositsConverter::fromDepositsToDepositsDto)
                .collect(Collectors.toList());
        return depositsList;
    }

    @Override
    public void deleteDeposit(Integer depositId) {
        depositsRepository.deleteById(depositId);
    }

        private void validateUserDto(DepositsDto depositsDto) throws ValidationException {
            if (isNull(depositsDto)) {
                throw new ValidationException("Object user is null");
            }
        }

}
