package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepositsDto {
        private Integer id;
        private String amount;
        private String percent;
        private String term;
        private String purpose;
        private Integer userId;
}
