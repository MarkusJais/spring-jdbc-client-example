package com.markusjais.examples.springjdbc.entities;


import jakarta.validation.constraints.NotNull;

public record Book(
        Long id,

        String title,
        String author,
        double price) {

//        public Book(String title, String isbn, String author, double price) {
//              this(null, title, isbn, author, price);
//        }
}



/*
    CREATE TABLE books (
        book_id              SERIAL PRIMARY KEY,
        title           VARCHAR(100) NOT NULL,
        isbn  VARCHAR(32) NOT NULL,
        author  VARCHAR(100) NOT NULL,
        price numeric
);

http -v POST http://localhost:8080/books author='Ian Newton' isbn=9780008298524 title='Upland Birds' price:=40.00


*/
