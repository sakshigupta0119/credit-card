package com.project.credit.card.service;

import com.project.credit.card.Entities.Users;
import com.project.credit.card.dao.UserRepository;
import com.project.credit.card.exception.RecordExistsException;
import com.project.credit.card.exception.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private UserRepository repository;

    //insert new user
    public Users insertUser(Users user) throws RecordExistsException {
        if(repository.existsById(user.getCustomerId()))
            throw new RecordExistsException("User with "+user.getCustomerId()+"already exists");
        long count = this.repository.count();
        user.setCustomerId(count+1);
        Users savedUser = repository.save(user);
        System.out.printf("There are now %d users\n", repository.count());
        return  savedUser;
    }
    //get all users
    public List<Users> getAllUsers()
    {
        return this.repository.findAll();
    }
    public Users getUserById(long userId) throws RecordNotFoundException {
        return repository.findById(userId)
                .orElseThrow(()->new RecordNotFoundException("user with "+userId+" does not exist"));
    }


    //Deleting a user
    public void deleteUser(long userId) throws RecordNotFoundException {

        if(!repository.existsById(userId))
            throw new RecordNotFoundException("user with "+userId+" does not exist");
        repository.deleteById(userId);
    }

    public List<Users> getTransactionsByGender(String gender) {
        return repository.getAllTransactionByGender(gender);
    }
}
