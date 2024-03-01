package com.markusjais.examples.springjdbc.entities;


public record Admin(
        long adminId,
        String password,
        String firstname,
        String lastname,
        String emailAddress) {
}


/*
    CREATE TABLE customers (
        customer_id              SERIAL PRIMARY KEY,
        firstname           VARCHAR(100) NOT NULL,
        lastname           VARCHAR(100) NOT NULL,
        email_address VARCHAR(100)
),

*/
