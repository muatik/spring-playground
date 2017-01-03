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
@RequestMapping("/api/v1/library/")
public class LibraryController {

    @Autowired
    LibraryService service;


    @GetMapping
    public String get() {
        service.add();
        return "OK";
    }


}
