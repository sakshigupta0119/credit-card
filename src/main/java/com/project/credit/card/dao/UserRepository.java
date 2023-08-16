package com.project.credit.card.dao;

import com.project.credit.card.Entities.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<Users , Long> {

    List<Users> findUsersByGender(String gender);
}
