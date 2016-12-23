package com.test.services;

import com.test.forms.UserForm;
import com.test.models.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by mustafaatik on 23/12/16.
 */
public interface UserService {
    User findOne(Long id);
    Collection<User> findAll();
    User save(UserForm user);
    void delete(Long id);

    User getUserByEmail(String email);
}
