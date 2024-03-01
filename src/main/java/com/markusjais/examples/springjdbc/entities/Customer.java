package com.markusjais.examples.springjdbc.entities;


public record Customer(
        long customerId,
        String firstname,
        String lastname,
        Country country,
        String emailAddress) {
}


/*
    CREATE TABLE customers (
        customer_id              SERIAL PRIMARY KEY,
        firstname           VARCHAR(100) NOT NULL,
        lastname           VARCHAR(100) NOT NULL,
        country VARCHAR(100) NOT NULL,
        email_address VARCHAR(100)
),

*/
