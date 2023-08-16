package com.project.credit.card.controller;
import com.project.credit.card.Entities.transactions;
import com.project.credit.card.dao.transactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.project.credit.card.services.transactionsServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class transactionsController {

    @Autowired
    private transactionsServices transactionsServices;
    @PostMapping("/")
    public long addAllTransactions(@RequestBody transactions transactions){
        return transactionsServices.save(transactions);
    }

    @GetMapping("/")
    public List<transactions> getAllTransactions(@RequestBody transactions transactions){
            return transactionsServices.findAll();
    }

    @DeleteMapping("/{trans_num}")
    public void delete(@PathVariable long trans_num){
        transactionsServices.delete(trans_num);
    }

}
