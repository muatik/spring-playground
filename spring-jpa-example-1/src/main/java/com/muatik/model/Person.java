package com.muatik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by muatik on 1/7/17.
 */

@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String firstname;
    private String lastname;

    private float height;

    protected Person() {}

    public Person(float length, String name, String lastname) {
        this.height = length;
        this.firstname = name;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
