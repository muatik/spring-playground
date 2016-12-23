package com.test.forms;

import com.test.models.User;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by mustafaatik on 23/12/16.
 */
public class UserForm{
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordRepeated;

    @NotEmpty
    private User.Role role = User.Role.USER;

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

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }

}
