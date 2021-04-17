package com.example.demo.controller;

import com.example.demo.dto.CreditsList;
import com.example.demo.dto.DepositsDto;
import com.example.demo.dto.DepositsList;
import com.example.demo.entity.Deposits;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.DepositsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/deposits")
@AllArgsConstructor
@Log
public class DepositsController {

    private final DepositsService depositsService;

        @PostMapping("/save")
        public DepositsDto saveDeposits(@RequestBody DepositsDto depositsDto) throws ValidationException {
            log.info("Handling save deposit: " + depositsDto);
            return depositsService.saveDeposit(depositsDto);
        }

        @GetMapping("/list/{userId}")
        public ResponseEntity<DepositsList> findAll(@PathVariable Integer userId) {
            return ResponseEntity.ok(depositsService.findAllByUserId(userId));
        }

    @GetMapping("/list")
    public ResponseEntity<DepositsList> findAllAll() {
        return ResponseEntity.ok(depositsService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCredit(@PathVariable Integer id) {
        depositsService.deleteDeposit(id);
        return ResponseEntity.ok().build();
    }

}
