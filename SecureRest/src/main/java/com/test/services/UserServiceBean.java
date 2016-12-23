package com.test.services;

import com.test.forms.UserForm;
import com.test.models.User;
import com.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by mustafaatik on 23/12/16.
 */
@Service
public class UserServiceBean implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Collection<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User save(UserForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findOneByEmail(email);
    }


}
