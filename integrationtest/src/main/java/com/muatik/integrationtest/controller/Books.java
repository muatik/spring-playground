package com.muatik.integrationtest.controller;

import com.muatik.integrationtest.model.Book;
import com.muatik.integrationtest.service.BooksBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by mustafaatik on 30/12/16.
 */
@RestController
@RequestMapping("/api/v1/books/")
public class Books {
    @Autowired

    BooksBean service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Iterable<Book> get() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}/", produces = APPLICATION_JSON_VALUE)
    public Book get(@PathVariable long id) {
        return service.findOne(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return service.save(book);
    }
}
