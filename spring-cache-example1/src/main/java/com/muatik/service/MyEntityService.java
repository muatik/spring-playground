package com.muatik.service;

import com.muatik.model.MyEntity;
import com.muatik.repository.MyEntityRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by mustafaatik on 20/01/17.
 */
@Service
public class MyEntityService {

    private MyEntityRepository repository;

    public MyEntityService(MyEntityRepository repository) {
        this.repository = repository;
    }

    public Iterable<MyEntity> findAll() {
        return repository.findAll();
    }

    @Cacheable(value = "entities")
    public Optional<MyEntity> findOne(Long id) {
        return Optional.ofNullable(repository.findOne(id));
    }


    public MyEntity save(MyEntity entity) {
        return repository.save(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }
}
