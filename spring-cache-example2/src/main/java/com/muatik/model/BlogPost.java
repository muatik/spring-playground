package com.muatik.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafaatik on 25/01/17.
 */

@Entity
public class BlogPost {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PostComment> comments = new ArrayList<>();


    private BlogPost() {}

    public BlogPost(String name) {
        this.title = name;
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

    public void setId(long id) {
        this.id = id;
    }

    public List<PostComment> getComments() {
        return comments;
    }

    public void addComment(PostComment comment) {
        comments.add(comment);
    }
}
