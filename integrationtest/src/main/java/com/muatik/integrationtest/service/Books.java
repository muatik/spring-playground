package com.muatik.integrationtest.service;

import com.muatik.integrationtest.model.Book;

/**
 * Created by mustafaatik on 30/12/16.
 */
public interface Books {
    Book findOne(long id);
    Iterable<Book> findAll();
    Book save(Book book);
    void delete(long id);
}
