package com.muatik.forms;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by mustafaatik on 26/12/16.
 */
public class UserForm {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    private String password;

    private String passwordRepeated;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
