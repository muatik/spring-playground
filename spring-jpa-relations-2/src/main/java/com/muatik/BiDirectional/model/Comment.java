package com.muatik.BiDirectional.model;

import org.hibernate.ObjectDeletedException;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Objects;

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

    /**
     * if OneToMany releation has CASCADE.ALL cascading mode, then post entity
     * needs to be saved before comment save operation. That is, the following
     * post has to have non-null id field.
     *
     * On the other hand, without cascading, you will able to pass unsaved post
     * entity. While saving the comment entity, unsaved post entity will be saved too.
     */
    @ManyToOne
    private Post post;

    public Comment() {}

    public Comment(String text, Post post) {
        this.text = text;
        this.post = post;
    }

    public Comment(String text, String author, Post post) {
        this.text = text;
        this.author = author;
        this.post = post;
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

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, post, text);
    }
}
