package com.muatik.integrationtest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mustafaatik on 30/12/16.
 */
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    public Book() {
        super();
    }

    public Book(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
