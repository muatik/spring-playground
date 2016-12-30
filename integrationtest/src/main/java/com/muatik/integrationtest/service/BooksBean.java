package com.muatik.integrationtest.service;

import com.muatik.integrationtest.model.Book;
import com.muatik.integrationtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mustafaatik on 30/12/16.
 */
@Service
public class BooksBean implements Books {
    @Autowired
    UserRepository repository;

    @Override
    public Book findOne(long id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
