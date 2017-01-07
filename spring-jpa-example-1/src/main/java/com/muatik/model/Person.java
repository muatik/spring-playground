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

    private String name;

    private float height;

    protected Person() {}

    public Person(float length, String name) {
        this.height = length;
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

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
