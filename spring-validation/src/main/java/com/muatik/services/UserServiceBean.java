package com.muatik.services;

import com.muatik.forms.UserForm;
import com.muatik.forms.UserFormValidator;
import com.muatik.models.User;
import com.muatik.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collection;

/**
 * Created by mustafaatik on 26/12/16.
 */
@Service
public class UserServiceBean implements UserService{
    @Autowired
    UserRepository repository;

    @Autowired
    UserFormValidator validator;

    private void validate(UserForm userForm) throws NoSuchMethodException, MethodArgumentNotValidException {
        BindingResult errors = new BindException(userForm, "userForm");
        validator.validate(userForm, errors);
        if (errors.hasErrors()) {
            throw new MethodArgumentNotValidException(
                    new MethodParameter(
                            this.getClass().getDeclaredMethod("validate", UserForm.class), 0),
                    errors);
        }
    }

    @Override
    public Collection<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public User save(UserForm userForm) throws NoSuchMethodException, MethodArgumentNotValidException {
        validate(userForm);
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setHashedPassword(userForm.getPassword());
//        user.setHashedPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        return repository.save(user);
    }


    @Override
    public User update(Long id, UserForm userForm) throws NoSuchMethodException, MethodArgumentNotValidException {
        validate(userForm);
        User user = findOne(id);
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        if (userForm.getPassword() != null)
            user.setHashedPassword(userForm.getPassword());
        return repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public User findOneByEmail(String email) {
        return repository.findOneByEmail(email);
    }

}
