package com.markusjais.examples.springjdbc.entities;


//public record OrderItem (
//     long orderItemId,
//     long orderId,
//     long bookId,
//     int quantity) {}


/*
   CREATE TABLE order_items (
    order_item_id              SERIAL PRIMARY KEY,
    order_id int NOT NULL,
    book_id int NOT NULL,
    quantity int NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON UPDATE CASCADE,
    FOREIGN KEY (book_id) REFERENCES books(book_id) ON UPDATE CASCADE
);

https://stackoverflow.com/questions/17711324/database-structure-for-customer-table-having-many-orders-per-customer-and-many/17711375


*/
