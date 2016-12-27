package com.muatik.forms;

import com.muatik.models.User;
import com.muatik.services.UserServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by mustafaatik on 26/12/16.
 */
@Component
public class UserFormValidator implements Validator {

    @Autowired
    UserServiceBean service;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm userForm = (UserForm) target;
        User userByEmail = service.findOneByEmail(userForm.getEmail());
        Operation operation = Operation.INSERT;

        if (userForm.getId() != null) {
            operation = Operation.UPDATE;
        }

        if (userByEmail != null && !userByEmail.getId().equals(userForm.getId())) {
            errors.reject("email.exists", "User with this email already exists");
        }

        if ((operation.equals(Operation.INSERT) || userForm.getPassword() != null) &&
                !userForm.getPassword().equals(userForm.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    public enum Operation {
        INSERT, UPDATE
    }
}
