package com.markusjais.examples.springjdbc.controllers;


import com.markusjais.examples.springjdbc.entities.Customer;
import com.markusjais.examples.springjdbc.exceptions.ResourceNotFoundException;
import com.markusjais.examples.springjdbc.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "customerId") Long customerId)
            throws ResourceNotFoundException {
        System.out.println("C_2");
        var customer = customerService.findCustomerById(customerId);
        return ResponseEntity.ok().body(customer);
    }


    @GetMapping
    public List<Customer> getAllCustomers() {
        System.out.println("C_1");
        var allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

//    @PostMapping
//    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
//        var customerCreated = customerService.createCustomer(customer);
//        return  new ResponseEntity<>(customerCreated, HttpStatus.CREATED);
//    }
}

// http -v POST http://localhost:8080/customers firstname='John' lastname='Doe' country='UK' emailAddress='johndoe@johndoe.co.uk'