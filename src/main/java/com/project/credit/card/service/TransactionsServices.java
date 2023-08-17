package com.project.credit.card.service;

import com.project.credit.card.dao.TransactionsMongoDB;
import com.project.credit.card.entities.transactions;
import com.project.credit.card.repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.credit.card.dto.*;

import java.util.List;

@Service
public class TransactionsServices {
@Autowired
    private static TransactionsRepository repo;
    @Autowired
    private TransactionsMongoDB dao;

    public List<SpendByGender> getGenderWiseSpending(){
        return dao.getSpendHistoryByGender();
    }

    public List<SpendByCategory> getCategoryWiseSpending(){
        System.out.println("In service");
        return dao.getSpendingHistoryByCategory();
    }

    public List<SpendByCity> getCityWiseSpending(){
        return dao.getSpendingHistoryByCity();
    }

    public List<SpendByState> getStateWiseSpending(){
        return dao.getSpendingHistoryByState();
    }

    public List<SpendByMerchant> getMerchantWiseSpending(){
        return dao.getSpendingHistoryByMerchant();
    }

    public List<SpendByOccupation> getJobWiseSpending(){
        return dao.getSpendingHistoryByProfession();
    }

    public List<transactions> getLowValueTransactions(){
        return dao.getLowValueTransactions();
    }

    public List<transactions> getHighValueTransactions(){
        return dao.getHighValueTransactions();
    }

    @Autowired
    public TransactionsServices(TransactionsRepository _transactionRepo)
    {
        this.repo =_transactionRepo;
    }


    public static List<transactions> getTransactionsByUserId(String _userId)
    {
        return repo.findByUserId(_userId);
    }
    public List<transactions> getTransactionsByMerchant(String _merchant)
    {
        return repo.findByMerchant(_merchant);
    }

    public List<transactions> getTransactionsBySpendingCategory(String _spendingCategory)
    {
        return repo.findBySpendingCategory(_spendingCategory);
    }

    public transactions createTransaction(transactions transaction)
    {
        return repo.save(transaction);
    }

}
