package com.muatik.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by muatik on 1/7/17.
 */
@Entity
public class Address {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String city;

    @NotBlank
    private String country;



    protected Address() {}

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
