package com.test.controllers;

import com.sun.deploy.net.HttpResponse;
import com.test.forms.UserForm;
import com.test.forms.UserFormValidator;
import com.test.services.UserServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


/**
 * Created by mustafaatik on 23/12/16.
 */
@RestController
@RequestMapping("/users/")
public class UsersController {

    @Autowired
    UserServiceBean users;

    @Autowired
    private UserFormValidator userValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String getUsers() {
        return "users";
    }

    @RequestMapping(
            value = "/registration/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity.BodyBuilder register(@RequestBody UserForm form, BindingResult result) throws Exception {
        userValidator.validate(form, result);
        if (result.hasErrors()) {
            throw new Exception(result.getAllErrors().toString());
        }
        users.save(form);
        return ResponseEntity.status(HttpStatus.CREATED);
    }

}
