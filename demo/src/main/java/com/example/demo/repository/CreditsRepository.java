package com.example.demo.repository;

import com.example.demo.entity.Credits;
import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditsRepository extends JpaRepository<Credits, Integer> {

    List<Credits> findAllByUserId(Users userId);
}
