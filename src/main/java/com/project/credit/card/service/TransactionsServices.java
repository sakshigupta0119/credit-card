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
    @Autowired
    private TransactionMongoTemplate dao;

    public List<SpendingByGender> getGenderwiseSpending(){
        return dao.getSpendingHistoryByGender();
    }

    public List<SpendingByCategory> getCategorywiseSpending(){
        System.out.println("In service");
        return dao.getSpendingHistoryByCategory();
    }

    public List<SpendingByCity> getCitywiseSpending(){
        return dao.getSpendingHistoryByCity();
    }

    public List<SpendingByState> getStatewiseSpending(){
        return dao.getSpendingHistoryByState();
    }

    public List<SpendingByMerchant> getMerchantwiseSpending(){
        return dao.getSpendingHistoryByMerchant();
    }

    public List<SpendingByProfession> getJobwiseSpending(){
        return dao.getSpendingHistoryByProfession();
    }

    public List<transactions> getLowValueTransactions(){
        return dao.getLowValueTransactions();
    }

    public List<transactions> getHighValueTransactions(){
        return dao.getHighValueTransactions();
    }

    @Autowired
    public TransactionsServices(TransactionRepo _transactionRepo)
    {
        this.repo =_transactionRepo;
    }

    public List<transactions> getTransactionsByUserId(String _userId)
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

    public Transaction createTransaction(Transaction transaction)
    {
        return transactionRepo.save(transaction);
    }


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
