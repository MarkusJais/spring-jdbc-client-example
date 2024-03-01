package com.markusjais.examples.springjdbc.controllers;


import com.markusjais.examples.springjdbc.entities.Book;
import com.markusjais.examples.springjdbc.exceptions.ResourceNotFoundException;
import com.markusjais.examples.springjdbc.service.BookService;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    private final MeterRegistry meterRegistry;

    public BookController(BookService bookService, MeterRegistry meterRegistry) {
        this.bookService = bookService;
        this.meterRegistry = meterRegistry;
    }


    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "bookId") Long bookId)
            throws ResourceNotFoundException {
        meterRegistry.counter("book_read_counter").increment();
        var book = bookService.findBookById(bookId);
        return ResponseEntity.ok().body(book);
    }

//    @GetMapping("/search")
//    public List<Book> getBooksByAuthor(@RequestParam("author") String author)
//            throws ResourceNotFoundException {
//        return bookService.findBooksByAuthor(author);
//    }
//
//
//    @GetMapping
//    public List<Book> getAllBooks() {
//        return bookService.getAllBooks();
//    }
//
//    @PostMapping
//    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
//        meterRegistry.counter("book_creation_counter").increment();
//        System.out.println("book from json:" + book);
//        Book createdBook = bookService.createBook(book);
//        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{bookId}")
//    public void deleteBook(@PathVariable(value = "bookId") Long bookId) {
//        bookService.deleteBookById(bookId);
//    }

}

// http -v POST http://localhost:8080/books author='Don Winslow' isbn=9781108298524 title='The Border' price:=12.00
