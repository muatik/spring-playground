package com.muatik.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by mustafaatik on 03/01/17.
 */
@Entity
public class Author {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, targetEntity = Book.class)

    private List<Book> books = new ArrayList<Book>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
