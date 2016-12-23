package com.test.forms;

import com.test.services.UserServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by mustafaatik on 23/12/16.
 */
@Component
public class UserFormValidator implements Validator {
    @Autowired
    UserServiceBean userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm form = (UserForm) target;
        validatePassword(errors, form);
        validateEmail(errors, form);
    }

    private void validateEmail(Errors errors, UserForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validatePassword(Errors errors, UserForm form) {
        if (userService.getUserByEmail(form.getEmail()) != null) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }
}
