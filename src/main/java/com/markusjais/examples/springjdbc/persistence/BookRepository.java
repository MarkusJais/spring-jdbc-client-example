package com.markusjais.examples.springjdbc.persistence;

import com.markusjais.examples.springjdbc.entities.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRepository {
    public void deleteAll() {
    }

    public void saveAll(List<Book> customers) {
    }

    public List<Book> findAll() {
        return null;
    }
}
