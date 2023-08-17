package com.project.credit.card.dao;

import com.project.credit.card.Entities.transactions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface transactionsRepository extends MongoRepository<transactions, Long> {

    List<transactions> getAllTransactionByCity();

    List<transactions> getAllTransactionsByMerchant();

    List<transactions> getAllTransactionsByState();

    List<transactions> getAllTransactionsByJob();

    List<transactions> getAllTransactionsBySpendingCategory();

//    Long TransactionInRange(Double lowAmt, Double highAmt);
}
