package com.markusjais.examples.springjdbc.service;


import com.markusjais.examples.springjdbc.entities.Book;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    private final MeterRegistry meterRegistry;
    private final JdbcClient jdbcClient;


    public BookService(JdbcClient jdbcClient, MeterRegistry meterRegistry) {
        this.jdbcClient = jdbcClient;
        this.meterRegistry = meterRegistry;
    }


    public Book findBookById(Long id) {
        String sql = "select * from books where id=:id";
        return jdbcClient.sql(sql).param("id", id).query(Book.class).single();
    }


    public List<Book> findAll() {
        String sql = "select * from books";
        return jdbcClient.sql(sql).query(Book.class).list();
    }

    public Long createBook(Book book) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql("INSERT INTO books(title,author,price) values(?,?,?) returning id")
                .params(List.of(book.title(), book.author(), book.price()))
                .update(keyHolder);

        Long id = keyHolder.getKeyAs(Long.class);

        System.out.println("id:" + id);

        return id;
    }

    public void deleteAll() {
        String sql = "delete from books";
        int count = jdbcClient.sql(sql).update();
        System.out.println("number of rows deleted:" + count);
    }

//
//    public void deleteBookById(Long bookId) {
//        bookRepository.deleteById(bookId);
//    }
//
//    public List<Book> findBooksByAuthor(String author) {
//        return bookRepository.findByAuthor(author);
//    }
}