package com.project.credit.card.service;

import com.project.credit.card.entities.Customers;
import com.project.credit.card.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServices implements CustomerServicesImplementation {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerServices(CustomerRepository customerRepository){
        this.customerRepository =customerRepository;
    }

    public List<Customers> getCustomerByGender(String gender)
    {
        return customerRepository.findByGender(gender);
    }

    public List<Customers> getCustomerByOccupation(String occupation)
    {
        return customerRepository.findByOccupation(occupation);
    }

    public Customers createCustomer(Customers customer)
    {
        return customerRepository.save(customer);
    }

    public Customers updateCustomer(String id, Customers customer) {

        Customers existingCustomer = customerRepository.findByCustomerId(id);
        System.out.println("old customer: "+existingCustomer);
        if (existingCustomer != null) {
            existingCustomer.setFirst(customer.getFirst());
            existingCustomer.setLast(customer.getLast());
            existingCustomer.setGender(customer.getGender());
            existingCustomer.setJob(customer.getJob());
            System.out.println("updated customer: "+existingCustomer);
            customerRepository.save(existingCustomer);
        }

        return existingCustomer;
    }


    public boolean deleteCustomer(String id)
    {
        Customers customerOptional= customerRepository.findByCustomerId(id);
        if(customerOptional !=null)
        {
            customerRepository.deleteByCustomerId(id);
            return true;
        }
        else {
            return false;
        }
    }


}

