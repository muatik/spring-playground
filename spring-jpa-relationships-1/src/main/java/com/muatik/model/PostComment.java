package com.muatik.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by muatik on 1/29/17.
 */
@Entity
public class PostComment implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    /**
     * NotEmpty ensures that the field contains data, even the empty string is not allowed.
     * This jpa annotation will also cause hibernate to mark this field "NOT NULL" on the database layer.
     */
    @NotEmpty  // instead of NotNull or even NotBlank. see: http://stackoverflow.com/questions/17137307/in-hibernate-validator-4-1-what-is-the-difference-between-notnull-notempty
    private String comment;

    /**
     * this will create a foreign key constrain to the id of the blogpost table on the comments table.
     * That is, there will not be a relationship table between the post tables and the comments table.
     * As a consequence, this entity can be in relationship with only the blog post entity. For example,
     * it cannot be a comment of another entity, let's say, a comment of a product.
     * On the other hand, the blogpost entity will not be aware of this relationship if it is not
     * implemented explicitly.
     *
     * Hibernate:
     * without NotEmpty and with eagerly fetched, an sql statement like the following will be issued to
     * retrieve a post comment through a repository.
     *
     * select
     *     postcommen0_.id as id1_1_0_, postcommen0_.comment as comment2_1_0_, postcommen0_.post_id as post_id3_1_0_, blogpost1_.id as id1_0_1_, blogpost1_.name as name2_0_1_
     * from post_comment postcommen0_
     * left outer join blog_post blogpost1_ on postcommen0_.post_id=blogpost1_.id
     * where postcommen0_.id=?
     *
     *
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    /**
     * NotEmpty, NotNUll or NotBlank cannot be applied on custom objects such as this post entity.
     * This annotation will cause the post object is also persisted whenever the comment object is going to be persistent.
     * After annotated with JoinColumn, "left outer join" is replaced with "inner join"
     */
//    @JoinColumn(nullable = false)
    private BlogPost post;



    public PostComment() {}

    public PostComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BlogPost getPost() {
        return post;
    }

    public void setPost(BlogPost post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
