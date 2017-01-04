package com.muatik.controller;

import com.muatik.model.MyEntity;
import com.muatik.service.MyEntityServiceImpl;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by muatik on 12/31/16.
 */
@RestController
@RequestMapping("/api/v1/entity/")
public class EntityController {

    @Autowired
    MyEntityServiceImpl service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Iterable<MyEntity> get() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}/", produces = APPLICATION_JSON_VALUE)
    public MyEntity get(@PathVariable long id) {
        return service.findOne(id).orElseThrow(() -> new NoSuchElementException("entity not found"));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public MyEntity create(@RequestBody MyEntity entity) {
        return service.save(entity);
    }
}
