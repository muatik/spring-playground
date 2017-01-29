package com.muatik.controller;

import com.muatik.model.BlogPost;
import com.muatik.service.MyEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by muatik on 1/29/17.
 */

@RestController
@RequestMapping("/api/v1/entity/")
public class EntityController {

    @Autowired
    MyEntityServiceImpl service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Iterable<BlogPost> get() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}/", produces = APPLICATION_JSON_VALUE)
    public BlogPost get(@PathVariable long id) {
        return service.findOne(id).orElseThrow(() -> new NoSuchElementException("entity not found"));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public BlogPost create(@RequestBody BlogPost entity) {
        return service.save(entity);
    }
}
