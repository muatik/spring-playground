package com.muatik.service;

import com.muatik.model.Book;
import com.muatik.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by mustafaatik on 06/01/17.
 */
@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public void save(Book book) {
        repository.save(book);
    }

}
