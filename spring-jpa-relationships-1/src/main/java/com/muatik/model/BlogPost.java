package com.muatik.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by muatik on 1/29/17.
 */

@Entity
public class BlogPost implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public BlogPost() {}

    public BlogPost(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
