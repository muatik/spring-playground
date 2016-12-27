package com.muatik.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mustafaatik on 26/12/16.
 */
@RestController
public class UnsecuredArea {

    @RequestMapping("/about/")
    public String getAbout() {
        return "about page";
    }

    @RequestMapping("/index/")
    public String getIndex() {
        return "index page";
    }

    @RequestMapping("/verySecured/")
    public String getVeryVerySecured() {
        return "very very secured";
    }
}
