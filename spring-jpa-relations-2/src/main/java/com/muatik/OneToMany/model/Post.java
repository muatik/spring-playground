package com.muatik.OneToMany.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafaatik on 01/02/2017.
 */

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

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

    public long getId() {
        return id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
