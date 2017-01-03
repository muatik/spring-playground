package com.muatik.service;

import com.muatik.model.Author;
import com.muatik.model.Book;
import com.muatik.repository.AuthorRepository;
import com.muatik.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by mustafaatik on 03/01/17.
 */
@Service
public class LibraryService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    public Author add() {

        Book book1 = new Book();
        book1.setTitle("book1");

        bookRepository.save(book1);

        Author author1 = new Author();
        author1.setName("author1");
        author1.getBooks().add(book1);
        authorRepository.save(author1);

        // due to this exception, the operations above will not be persistent.
        throw new RuntimeException();

        //return author1;
    }

}
