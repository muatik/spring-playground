package com.muatik.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    protected Person() {}

    public Person(float length, String name, String lastname, Address address) {
        this.height = length;
        this.firstname = name;
        this.lastname = lastname;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return getId() + " - " + getFirstname() + " from " + getAddress().getCity();
    }
}
