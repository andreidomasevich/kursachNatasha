package com.example.demo.repository;

import com.example.demo.entity.Deposits;
import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositsRepository extends JpaRepository<Deposits, Integer> {

    List<Deposits> findAllByUserId(Users userId);
}
