package com.project.credit.card.repositories;

import com.project.credit.card.entities.customers;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<customers, Long> {



    List<customers> findByGender(String gender);

    List<customers> findByOccupation(String occupation);

    customers findByCustomerId(String id);

    void deleteByCustomerId(String id);
}
