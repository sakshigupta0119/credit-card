package com.project.credit.card.controller;

import com.project.credit.card.Entities.customers;
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
@Autowired
    private CustomerServices customerService;


@GetMapping("/gender/{gender}")
    public ResponseEntity<List<customers>> getCustomerByGender(@PathVariable String gender){
    List<customers> customer = CustomerServices.getCustomerByGender(gender);
    return ResponseEntity.ok(customer);
}

@GetMapping("/occupation/{occupation}")
    public ResponseEntity<List<customers>> getCustomerByOccupation(@PathVariable String occupation) {
    List<customers> customer = CustomerServices.getCustomerByOccupation(occupation);
    return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<customers> createCustomer(@RequestBody customers customer){
    customers newCustomer = CustomerServices.createCustomer(customer);
    return ResponseEntity.created(URI.create("/customers/"+ newCustomer.getCustomerId())).body(newCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<customers> updateCustomer(@PathVariable String id, @RequestBody customers customer) {
        System.out.println("Customer's ID: " + id);
        customers changeCustomer = CustomerServices.updateCustomer(id, customer);
        if (changeCustomer != null) {
            return ResponseEntity.ok(changeCustomer);
        } else {
            ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id){
     if(CustomerServices.deleteCustomer(id)){
         return ResponseEntity.noContent().build();
     }
     else{
         return ResponseEntity.notFound().build();
     }
    }
}
