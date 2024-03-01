package com.markusjais.examples.springjdbc.service;


import com.markusjais.examples.springjdbc.entities.Customer;
import com.markusjais.examples.springjdbc.exceptions.ResourceNotFoundException;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;


@Service
public class CustomerService {

    private final MeterRegistry meterRegistry;
    private final JdbcClient jdbcClient;



    public CustomerService(JdbcClient jdbcClient, MeterRegistry meterRegistry) {
        this.jdbcClient = jdbcClient;
        this.meterRegistry = meterRegistry;
    }


    public Customer findCustomerById(Long customerId)
            throws ResourceNotFoundException {
        String sql = "select * from customers where customer_id=:customer_id";
        return jdbcClient.sql(sql).param("customer_id", customerId).query(Customer.class).single();

    }


    public List<Customer> getAllCustomers() {
        String sql = "select * from customers";
        return jdbcClient.sql(sql).query(Customer.class).list();
    }

//    public Customer createCustomer(Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    public void deleteCustomerById(Long bookId) {
//        customerRepository.deleteById(bookId);
//    }

}