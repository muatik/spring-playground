package com.muatik.ManyToOne.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mustafaatik on 01/02/2017.
 */

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    public Post(){}
    public Post(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
