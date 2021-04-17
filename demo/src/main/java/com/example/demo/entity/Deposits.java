package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "deposits")
@Data
@NoArgsConstructor
public class Deposits {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "amount")
        private String amount;

        @Column(name = "percent")
        private String percent;

        @Column(name = "term")
        private String term;

        @Column(name = "purpose")
        private String purpose;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private Users userId;
}
