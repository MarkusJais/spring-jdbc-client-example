package com.markusjais.examples.springjdbc.service;

import com.markusjais.examples.springjdbc.entities.Book;
import com.markusjais.examples.springjdbc.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql({"/schema.sql"})
class BookServiceTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:latest"
    );

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @Autowired
    BookService bookService;

    @BeforeEach
    void setUp() {
        bookService.deleteAll();
    }

    @Test
    void connectionEstablished() {
        assertThat(postgres.isCreated()).isTrue();
        assertThat(postgres.isRunning()).isTrue();
    }

    @Test
    void insertAndGetOneBook()  {
        var lotr =        new Book(null, "The Lord of the Rings", "J.R.R. Tolkien", 20.0);
        Long id = bookService.createBook(lotr);

        var lotrFromDb = bookService.findBookById(id);
        System.out.println(lotrFromDb);
        assertThat(lotrFromDb).isNotNull();
    }

    @Test
    void shouldGetAllBooks() {
        List<Book> books = List.of(
                new Book(null, "The Lord of the Rings", "J.R.R. Tolkien", 20.0),
                new Book(null, "Bleak House", "Charles Dickens", 15.0)
        );
        books.forEach(bookService::createBook);
        var allBooks = bookService.findAll();
        assertThat(allBooks).hasSize(2);
    }
}