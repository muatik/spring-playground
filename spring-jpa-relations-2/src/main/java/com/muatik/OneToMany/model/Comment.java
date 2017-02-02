package com.muatik.OneToMany.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by mustafaatik on 01/02/2017.
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String text;

    @NotBlank
    private String author;

    public Comment() {}

    public Comment(String text) {
        this.text = text;
    }

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
