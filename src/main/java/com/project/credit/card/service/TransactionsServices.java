package com.project.credit.card.service;

import com.project.credit.card.Entities.transactions;
import com.project.credit.card.dao.transactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsServices {
@Autowired
    private transactionsRepository repo;

    public List<transactions> getTransactionsByCity(String city){
        return repo.getAllTransactionByCity();
    }
    public List<transactions> getTransactionByMerchant(String merchant){
        return  repo.getAllTransactionsByMerchant();
    }


    public List<transactions> getTransactionsByState(String state) {
        return repo.getAllTransactionsByState();
    }

    public List<transactions> getTransactionsBySpendingCategory(String category) {
        return  repo.getAllTransactionsBySpendingCategory();
    }

    public List<transactions> getTransactionsByJob(String job) {
        return repo.getAllTransactionsByJob();
    }
    public transactions insertTransaction(transactions transaction)  {
          long count = this.repo.count();
        transactions savedTransaction = repo.save(transaction);
       // System.out.printf("There are now %d users\n", repo.count());
        return  savedTransaction;
    }

}
