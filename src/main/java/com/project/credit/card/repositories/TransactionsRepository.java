package com.project.credit.card.repositories;

import com.project.credit.card.entities.Transactions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionsRepository extends MongoRepository<Transactions, Long> {

  //  List<transactions> getAllTransactionByCity();

//    List<transactions> getAllTransactionsByMerchant();
//
//    List<transactions> getAllTransactionsByState();
//
//    List<transactions> getAllTransactionsByJob();
//
//    List<transactions> getAllTransactionsBySpendingCategory();

    List<Transactions> findBySpendingCategory(String spendingCategory);

    List<Transactions> findByMerchant(String merchant);

    List<Transactions> findByUserId(String userId);

//    Long TransactionInRange(Double lowAmt, Double highAmt);
}
