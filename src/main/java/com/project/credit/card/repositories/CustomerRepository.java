package com.project.credit.card.repositories;

import com.project.credit.card.entities.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customers, Long> {



    List<Customers> findByGender(String gender);

    List<Customers> findByOccupation(String occupation);

    Customers findByCustomerId(String id);

    void deleteByCustomerId(String id);
}
