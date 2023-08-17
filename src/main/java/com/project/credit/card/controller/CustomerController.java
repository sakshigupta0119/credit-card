package com.project.credit.card.controller;

import com.project.credit.card.entities.customers;
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
    public ResponseEntity<List<customers>> getCustomerByGender(@PathVariable String gender){
    List<customers> customer = customerService.getCustomerByGender(gender);
    return ResponseEntity.ok(customer);
}

@GetMapping("/occupation/{occupation}")
    public ResponseEntity<List<customers>> getCustomerByOccupation(@PathVariable String occupation) {
    List<customers> customer = customerService.getCustomerByOccupation(occupation);
    return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<customers> createCustomer(@RequestBody customers customer){
    customers newCustomer = customerService.createCustomer(customer);
    return ResponseEntity.created(URI.create("/customers/"+ newCustomer.getCustomerId())).body(newCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<customers> updateCustomer(@PathVariable String id, @RequestBody customers customer) {
        System.out.println("Customer's ID: " + id);
        customers changeCustomer = customerService.updateCustomer(id, customer);
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
