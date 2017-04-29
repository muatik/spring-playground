package com.muatik.model;

import javax.persistence.*;

/**
 * Created by mustafaatik on 25/01/17.
 */
@Entity
public class PostComment {

    @Id
    @GeneratedValue
    private long id;
    private String comment;

    public PostComment() {}

    public PostComment(String comment) {
        this.comment = comment;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
