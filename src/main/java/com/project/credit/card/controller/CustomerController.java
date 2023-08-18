package com.project.credit.card.controller;

import com.project.credit.card.entities.Customers;
import com.project.credit.card.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerServices customerService;

    @Autowired
    public CustomerController(CustomerServices _customerService){
        this.customerService = _customerService;
    }


@GetMapping("/gender/{gender}")
    public ResponseEntity<List<Customers>> getCustomerByGender(@PathVariable String gender){
    List<Customers> customer = customerService.getCustomerByGender(gender);
    return ResponseEntity.ok(customer);
}

@GetMapping("/occupation/{occupation}")
    public ResponseEntity<List<Customers>> getCustomerByOccupation(@PathVariable String occupation) {
    List<Customers> customer = customerService.getCustomerByOccupation(occupation);
    return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customer){
    Customers newCustomer = customerService.createCustomer(customer);
    return ResponseEntity.created(URI.create("/customers/"+ newCustomer.getCustomerId())).body(newCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable String id, @RequestBody Customers customer) {
        System.out.println("Customer's ID: " + id);
        Customers changeCustomer = customerService.updateCustomer(id, customer);
        if (changeCustomer == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(changeCustomer);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id){
     if(customerService.deleteCustomer(id)){
         return ResponseEntity.noContent().build();
     }
     else{
         return ResponseEntity.notFound().build();
     }
    }
}
