package com.project.credit.card.dao;

import com.project.credit.card.Entities.customers;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<customers, Long> {



    List<customers> findByGender(String gender);

    List<customers> findByProfession(String profession);

    customers findByCustomerId(String id);

    void deleteByCustomerId(String id);
}
