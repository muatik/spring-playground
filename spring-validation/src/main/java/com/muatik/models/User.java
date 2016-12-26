package com.muatik.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mustafaatik on 26/12/16.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Length(min=3, max = 100)
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    @Length(min=5, max = 100)
    private String email;

    @Column(nullable = false)
    @JsonIgnore
    private String hashedPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
