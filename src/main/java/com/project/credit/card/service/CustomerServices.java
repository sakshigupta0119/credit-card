package com.project.credit.card.service;

import com.project.credit.card.Entities.customers;
import com.project.credit.card.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServices implements CustomerServicesImplementation {
    private  CustomerRepository customerRepo;
    @Autowired
    public CustomerServices(CustomerRepository customerRepo){
        this.customerRepo =customerRepo;
    }

    public List<customers> getCustomerByGender(String _gender)
    {
        System.out.println("In customer service");
        return customerRepo.findByGender(_gender);
    }

    public List<customers> getCustomerByProfession(String _profession)
    {
        return customerRepo.findByProfession(_profession);
    }

    public customers createCustomer(customers customer)
    {
        return customerRepo.save(customer);
    }

    public customers updateCustomer(String id, customers customer) {
        System.out.println("Printing from Service Class" + id + customer);
        customers existingCustomer = customerRepo.findByCustomerId(id);
        System.out.println("old object"+existingCustomer);
        if (existingCustomer != null) {
//            Customer existingCustomer= existingCustomerOptional.get();
            existingCustomer.setFirst(customer.getFirst());
            existingCustomer.setLast(customer.getLast());
            existingCustomer.setGender(customer.getGender());
            existingCustomer.setJob(customer.getJob());
            System.out.println("*************"+existingCustomer);
            customerRepo.save(existingCustomer);
        }

        return existingCustomer;
    }


    public boolean deleteCustomer(String id)
    {
        customers customerOptional=customerRepo.findByCustomerId(id);
        if(customerOptional !=null)
        {
            customerRepo.deleteByCustomerId(id);
            return true;
        }
        else {
            return false;
        }
    }


}
