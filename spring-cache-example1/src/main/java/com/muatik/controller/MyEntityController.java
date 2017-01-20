package com.muatik.controller;

import com.muatik.model.MyEntity;
import com.muatik.service.MyEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by mustafaatik on 20/01/17.
 */
@RestController
@RequestMapping("/api/v1/entities/")
public class MyEntityController {

    private MyEntityService service;

    public MyEntityController(MyEntityService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<MyEntity> get() {
        return service.findAll();
    }

    @GetMapping("/{id}/")
    public ResponseEntity<MyEntity> getOne(@PathVariable long id) {
        Optional<MyEntity> entity = service.findOne(id);
        if (entity.isPresent()) {
            return new ResponseEntity<MyEntity>(entity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public MyEntity create(@RequestBody MyEntity entity) {
        return service.save(entity);
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity delete(@PathVariable long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
