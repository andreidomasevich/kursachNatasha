package com.example.demo.service;

import com.example.demo.dto.CreditsDto;
import com.example.demo.entity.Credits;
import com.example.demo.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class CreditsConverter {

    public Credits fromCreditsDtoToCredits(CreditsDto creditsDto) {
        Users users = new Users();
        users.setId(creditsDto.getUserId());

        Credits credits = new Credits();
        credits.setId(creditsDto.getId());
        credits.setAmount(creditsDto.getAmount());
        credits.setPercent(creditsDto.getPercent());
        credits.setPurpose(creditsDto.getPurpose());
        credits.setTerm(creditsDto.getTerm());

        credits.setUserId(users);
        return credits;
    }

    public CreditsDto fromCreditsToCreditsDto(Credits credits) {
        return CreditsDto.builder()
                .id(credits.getId())
                .amount(credits.getAmount())
                .percent(credits.getPercent())
                .purpose(credits.getPurpose())
                .term(credits.getTerm())
                .userId(credits.getUserId().getId())
                .build();
    }
}
