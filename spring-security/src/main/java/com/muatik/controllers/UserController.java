package com.muatik.controllers;

import com.muatik.forms.UserForm;
import com.muatik.forms.UserFormValidator;
import com.muatik.models.User;
import com.muatik.services.UserServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by mustafaatik on 26/12/16.
 */
@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserServiceBean users;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<User> get() {
        return users.findAll();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@Validated @RequestBody UserForm userForm) throws NoSuchMethodException, MethodArgumentNotValidException {
        users.save(userForm);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> update(@Validated @RequestBody UserForm userForm) throws NoSuchMethodException, MethodArgumentNotValidException {
        return new ResponseEntity<>(users.update(userForm.getId(), userForm), HttpStatus.OK);
    }
}
