//package com.markusjais.examples.springjdbc.controllers;
//
//
//import com.markusjais.examples.springbootkafka.repository.AdminRepository;
//import com.markusjais.examples.springbootkafka.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//
//    @DeleteMapping("/admin/delete/customers/{customerId}")
//    public void deleteCustomer(@PathVariable(value = "customerId") Long customerId) {
//        customerRepository.deleteById(customerId);
//    }
//}