package com.project.credit.card.controllerTest;

import com.project.credit.card.controller.CustomerController;
import com.project.credit.card.entities.Customers;
import com.project.credit.card.service.CustomerServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerControllerTest {

    @Mock
    private CustomerServices customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCustomerByGender() {
        String gender = "M";
        List<Customers> mockCustomers = new ArrayList<>();
        mockCustomers.add(new Customers(1,"","Deepak","Gowda","M","Software", LocalDate.of(2000,02,28)));

        when(customerService.getCustomerByGender(gender)).thenReturn(mockCustomers);

        ResponseEntity<List<Customers>> responseEntity = customerController.getCustomerByGender(gender);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockCustomers, responseEntity.getBody());
    }

    @Test
    void testGetCustomerByOccupation() {
        String occupation = "Software";
        List<Customers> mockCustomers = new ArrayList<>();
        mockCustomers.add(new Customers(1,"","Deepak","Gowda","M","Software",LocalDate.of(2000,02,28));

        when(customerService.getCustomerByOccupation(occupation)).thenReturn(mockCustomers);

        ResponseEntity<List<Customers>> responseEntity = customerController.getCustomerByOccupation(occupation);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockCustomers, responseEntity.getBody());
    }

    @Test
    void testCreateCustomer() {
        Customers newCustomer = new Customers(1,"","Deepak","Gowda","M","Software",LocalDate.of(2000,02,28);
        when(customerService.createCustomer(newCustomer)).thenReturn(newCustomer);

        ResponseEntity<Customers> responseEntity = customerController.createCustomer(newCustomer);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(newCustomer, responseEntity.getBody());
    }

    @Test
    void testUpdateCustomer() {
        String customerId = "1";
        Customers updatedCustomer = new Customers(1,"","Appu","Kumar","M","Doctor",LocalDate.of(2000,05,28));

        when(customerService.updateCustomer(customerId, updatedCustomer)).thenReturn(updatedCustomer);

        ResponseEntity<Customers> responseEntity = customerController.updateCustomer(customerId, updatedCustomer);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedCustomer, responseEntity.getBody());
    }

    @Test
    void testDeleteCustomer() {
        String customerId = "1";
        when(customerService.deleteCustomer(customerId)).thenReturn(true);

        ResponseEntity<Void> responseEntity = customerController.deleteCustomer(customerId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}