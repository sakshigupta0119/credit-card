package com.project.credit.card.repositories;

import com.project.credit.card.entities.transactions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionsRepository extends MongoRepository<transactions, Long> {

  //  List<transactions> getAllTransactionByCity();

//    List<transactions> getAllTransactionsByMerchant();
//
//    List<transactions> getAllTransactionsByState();
//
//    List<transactions> getAllTransactionsByJob();
//
//    List<transactions> getAllTransactionsBySpendingCategory();

    List<transactions> findBySpendingCategory(String spendingCategory);

    List<transactions> findByMerchant(String merchant);

    List<transactions> findByUserId(String userId);

//    Long TransactionInRange(Double lowAmt, Double highAmt);
}
