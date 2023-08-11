package com.project.credit.card.controller;

import com.project.credit.card.Entities.transactions;
import com.project.credit.card.dao.transactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class transactionsController {
    @Autowired
    private transactionsRepository transactionsRepository;
    @PostMapping("/")
    public ResponseEntity<?> addtransactions(@RequestBody transactions transactions){
        transactions save = this.transactionsRepository.save(transactions);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public ResponseEntity<?> gettransactions(@RequestBody transactions transactions){
        return ResponseEntity.ok(this.transactionsRepository.findAll());
    }
}
