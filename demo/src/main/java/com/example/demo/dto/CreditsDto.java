package com.example.demo.dto;

import com.example.demo.entity.Users;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class CreditsDto {
    private Integer id;
    private String amount;
    private String percent;
    private String term;
    private String purpose;
    private Integer userId;
}
