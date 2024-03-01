package com.markusjais.examples.springjdbc.entities;


import java.time.LocalDateTime;
import java.util.List;

//public record Order (
//     long orderId,
//     long customerId,
//     List<OrderItem> orderItems,
//     LocalDateTime orderDate) { }

/*
   CREATE TABLE orders (
    order_id              SERIAL PRIMARY KEY,
    customer_id int NOT NULL,
    order_date timestamp,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON UPDATE CASCADE
);


*/
