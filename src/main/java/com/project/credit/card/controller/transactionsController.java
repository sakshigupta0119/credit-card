package com.project.credit.card.controller;

import com.project.credit.card.dto.*;
import com.project.credit.card.entities.transactions;
import com.project.credit.card.service.TransactionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class transactionsController {

    private  TransactionsServices transactionService;
    @Autowired
    public transactionsController(TransactionsServices _transactionService)
    {
        this.transactionService =_transactionService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<transactions>> getTransactionByUserId(@PathVariable String userId)
    {
        List<transactions> transactions = TransactionsServices.getTransactionsByUserId(userId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/merchant/{merchant}")
    public ResponseEntity<List<transactions>> getTransactionsByMerchant(@PathVariable String merchant)
    {
        List<transactions> transactions=transactionService.getTransactionsByMerchant(merchant);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/category/{spendingCategory}")
    public ResponseEntity<List<transactions>> getTransactionsByCategory(@PathVariable String spendingCategory)
    {
        List<transactions> transactions= transactionService.getTransactionsBySpendingCategory(spendingCategory);
        return ResponseEntity.ok(transactions);
    }

    @PostMapping
    public ResponseEntity<transactions> createTransaction(@RequestBody transactions transaction)
    {
        transactions createdTransaction= transactionService.createTransaction(transaction);
        return ResponseEntity.created(URI.create("/transactions/"+createdTransaction.getTrans_num())).body(createdTransaction);
    }

    // For data visualization (charts) - MongoTemplate

    @GetMapping("/spendingHistory/Gender")
    public List<SpendByGender> getGenderWiseSpending()
    {
        return transactionService.getGenderWiseSpending();
    }

    @GetMapping("/spendingHistory/Category")
    public List<SpendByCategory> getCategoryWiseSpending()
    {
        System.out.println("In controller");
        return transactionService.getCategoryWiseSpending();
    }

    @GetMapping("/spendingHistory/City")
    public List<SpendByCity> getCityWiseSpending()
    {
        return transactionService.getCityWiseSpending();
    }

    @GetMapping("/spendingHistory/State")
    public List<SpendByState> getStatewiseSpending()
    {
        return transactionService.getStateWiseSpending();
    }

    @GetMapping("/spendingHistory/Merchant")
    public List<SpendByMerchant> getMerchantwiseSpending()
    {
        return transactionService.getMerchantWiseSpending();
    }

    @GetMapping("/spendingHistory/Job")
    public List<SpendByOccupation> getJobWiseSpending()
    {
        return transactionService.getJobWiseSpending();
    }

    @GetMapping("/spendingHistory/LowValueTransactions")
    public List<transactions> getLowValueTransactions()
    {
        return transactionService.getLowValueTransactions();
    }

    @GetMapping("/spendingHistory/HighValueTransactions")
    public List<transactions> getHighValueTransactions()
    {
        return transactionService.getHighValueTransactions();
    }
}


