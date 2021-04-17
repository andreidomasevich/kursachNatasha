package com.example.demo.controller;

import com.example.demo.dto.CreditsDto;
import com.example.demo.dto.CreditsList;
import com.example.demo.dto.UsersDto;
import com.example.demo.entity.Credits;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.CreditsService;
import com.example.demo.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/credits")
@AllArgsConstructor
@Log
public class CreditsController {
    private final CreditsService creditsService;

    @PostMapping("/save")
    public CreditsDto saveCredits(@RequestBody CreditsDto creditsDto) throws ValidationException {
        log.info("Handling save credit: " + creditsDto);
        return creditsService.saveCredit(creditsDto);
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<CreditsList> findAll(@PathVariable Integer userId) {
        return ResponseEntity.ok(creditsService.findAllByUserId(userId));
    }

    @GetMapping("/list")
    public ResponseEntity<CreditsList> findAllAll() {
        return ResponseEntity.ok(creditsService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCredit(@PathVariable Integer id) {
        creditsService.deleteCredit(id);
        return ResponseEntity.ok().build();
    }

}
