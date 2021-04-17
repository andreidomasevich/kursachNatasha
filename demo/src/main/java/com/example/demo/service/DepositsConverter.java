package com.example.demo.service;

import com.example.demo.dto.DepositsDto;
import com.example.demo.entity.Deposits;
import com.example.demo.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class DepositsConverter {

        public Deposits fromDepositsDtoToDeposits(DepositsDto depositsDto) {
            Users users = new Users();
            users.setId(depositsDto.getUserId());

            Deposits deposits = new Deposits();
            deposits.setId(depositsDto.getId());
            deposits.setAmount(depositsDto.getAmount());
            deposits.setPercent(depositsDto.getPercent());
            deposits.setPurpose(depositsDto.getPurpose());
            deposits.setTerm(depositsDto.getTerm());

            deposits.setUserId(users);
            return deposits;
        }

        public DepositsDto fromDepositsToDepositsDto(Deposits deposits) {
            return DepositsDto.builder()
                    .id(deposits.getId())
                    .amount(deposits.getAmount())
                    .percent(deposits.getPercent())
                    .purpose(deposits.getPurpose())
                    .term(deposits.getTerm())
                    .userId(deposits.getUserId().getId())
                    .build();
        }

}
