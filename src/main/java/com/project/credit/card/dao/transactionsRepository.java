package com.project.credit.card.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.project.credit.card.Entities.transactions;
public interface transactionsRepository extends MongoRepository<transactions, Long> {

}
