package com.muatik.controller;

import com.muatik.model.Book;
import com.muatik.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mustafaatik on 06/01/17.
 */
@RestController
@RequestMapping
public class BookController {

    @Autowired
    BookService service;

    @GetMapping()
    public String get() {
        Book b1 = new Book();
        Book b2 = new Book();
        b1.setTitle("b1");
        b2.setTitle("b2");

        service.save(b1);
        service.save(b2);

        b1.setTitle("b11");
        b2.setTitle("b22");

        service.save(b2);
        // this save operation causes that b2 will also be saved alongside b1
        return b1.getTitle() + "," + b2.getTitle();
    }
}
