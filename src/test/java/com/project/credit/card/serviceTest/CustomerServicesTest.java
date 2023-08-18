package com.project.credit.card.serviceTest;

import com.project.credit.card.entities.Customers;
import com.project.credit.card.repositories.CustomerRepository;
import com.project.credit.card.service.CustomerServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CustomerServicesTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerServices customerServices;

    Customers customer1, customer2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        customer1 = new Customers(2,"","Sakshi","Gupta","F","Software",LocalDate.of(2001,04,20));
        customer2 = new Customers(3,"","Harsh","Agarwal","M","Doctor", LocalDate.of(2001,03,19));
    }

    @Test
    public void testGetCustomerByGender() {
        String gender = "F";
        List<Customers> customersList = new ArrayList<>();
        customersList.add(customer1);

        when(customerRepository.findByGender(gender)).thenReturn(customersList);

        List<Customers> result = customerServices.getCustomerByGender(gender);
        assertEquals(customersList, result);
    }

    @Test
    public void testGetCustomerByOccupation() {
        String occupation = "Doctor";
        List<Customers> customersList = new ArrayList<>();
        customersList.add(customer2);

        when(customerRepository.findByOccupation(occupation)).thenReturn(customersList);

        List<Customers> result = customerServices.getCustomerByOccupation(occupation);
        assertEquals(customersList, result);
    }

    @Test
    public void testCreateCustomer() {
        when(customerRepository.save(customer1)).thenReturn(customer1);

        Customers createdCustomer = customerServices.createCustomer(customer1);
        assertEquals(customer1, createdCustomer);
    }

    @Test
    public void testUpdateCustomer() {
        String customerId = "2";
        Customers updatedCustomer = new Customers(3,"","Appu","Kumar","M","Doctor",LocalDate.of(2001,05,26));

        when(customerRepository.findByCustomerId(customerId)).thenReturn(customer1);
        when(customerRepository.save(customer1)).thenReturn(updatedCustomer);

        Customers result = customerServices.updateCustomer(customerId, updatedCustomer);
        assertEquals(updatedCustomer, result);
    }

    @Test
    public void testDeleteCustomer() {
        String customerId = "3";

        when(customerRepository.findByCustomerId(customerId)).thenReturn(customer2);
        doNothing().when(customerRepository).deleteByCustomerId(customerId);

        boolean deleted = customerServices.deleteCustomer(customerId);
        assertTrue(deleted);
    }
}
