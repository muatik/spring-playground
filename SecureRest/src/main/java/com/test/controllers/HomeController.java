package com.test.controllers;

import com.sun.org.apache.regexp.internal.RE;
import com.test.services.UserServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mustafaatik on 23/12/16.
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserServiceBean users;

    @RequestMapping(value = "/index/", method = RequestMethod.GET)
    public String getIndex() {
        return "Welcome to Index page.";
    }

    @RequestMapping(value = "/about/")
    public String getAbout() {
        return "about page";
    }

    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    public String getSomethingSecured() {
        return "something very secured, if you say so";
    }

}
