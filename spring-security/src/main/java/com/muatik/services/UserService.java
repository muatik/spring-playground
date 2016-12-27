package com.muatik.services;

import com.muatik.forms.UserForm;
import com.muatik.models.User;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collection;

/**
 * Created by mustafaatik on 26/12/16.
 */
public interface UserService {
    Collection<User> findAll();
    User findOne(Long id);
    User save(UserForm user) throws NoSuchMethodException, MethodArgumentNotValidException;
    User update(Long id, UserForm user) throws NoSuchMethodException, MethodArgumentNotValidException;
    User findOneByEmail(String email);
    void delete(Long id);
}
