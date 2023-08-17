package com.project.credit.card.dao;

import com.project.credit.card.Entities.customers;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<customers, Long> {


    List<customers> getAllTransactionByGender(String gender);
}
