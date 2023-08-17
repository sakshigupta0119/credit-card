package com.project.credit.card.controller;

import com.project.credit.card.entities.transactions;
import com.project.credit.card.service.TransactionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class transactionsController {

    @Autowired
    private TransactionsServices transactionService;


//    @GetMapping("/")
//    public List<transactions> getAllTransactions(@RequestBody transactions transactions){
//            return transactionService.findAll();
//    }

    @GetMapping("/city/{city}")
    public List<transactions> getTransactionsByCity(@PathVariable String city) {
        List<transactions> temp = this.transactionService.getTransactionsByCity(city);
        System.out.println(temp);
        return temp;
    }

    @GetMapping("/merchant/{merchant}")
    public List<transactions> getTransactionByMerchant(@PathVariable String merchant) {
        List<transactions> temp = this.transactionService.getTransactionByMerchant(merchant);
        System.out.println(temp);
        return temp;
    }

    @GetMapping("/state/{state}")
    public List<transactions> getTransactionsByState(@PathVariable String state) {
        List<transactions> temp = this.transactionService.getTransactionsByState(state);
        System.out.println(temp);
        return temp;
    }

    @GetMapping("/job/{job}")
    public List<transactions> getTransactionsByJob(@PathVariable String job) {
        List<transactions> temp = this.transactionService.getTransactionsByJob(job);
        System.out.println(temp);
        return temp;
    }

    //    By spending category
    @GetMapping("/category/{category}")
    public List<transactions> getTransactionsBySpendingCategory(@PathVariable String category) {
        List<transactions> temp = this.transactionService.getTransactionsBySpendingCategory(category);
        System.out.println(temp);
        return temp;
    }
}

