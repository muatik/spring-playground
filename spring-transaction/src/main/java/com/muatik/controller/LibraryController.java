package com.muatik.controller;

import com.muatik.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mustafaatik on 03/01/17.
 */
@RestController
@RequestMapping("/api/")
public class LibraryController {

    @Autowired
    LibraryService service;

    @GetMapping("library/transactional_add/")
    public String add_transactional() {
        service.add();
        return "OK";
    }

    @GetMapping("library/add_anyway/")
    public String add_anyway() {
        service.add_anyway();
        return "OK";
    }

    @GetMapping("/pollOptions/2voter/")
    public String voter1() {
        service.vote("2.voter", 1000);
        return "OK";
    }

    @GetMapping("/pollOptions/1voter/")
    public String voter2() {
        service.vote("1.voter", 3000);
        return "OK";
    }
}
