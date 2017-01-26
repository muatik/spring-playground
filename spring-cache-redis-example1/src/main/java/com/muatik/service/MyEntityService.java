package com.muatik.service;

import com.muatik.model.MyEntity;
import com.muatik.repository.MyEntityRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by mustafaatik on 26/01/17.
 */
@Service
public class MyEntityService {

    private MyEntityRepository repository;

    public MyEntityService(MyEntityRepository repository) {
        this.repository = repository;
    }

    @CachePut(value = "entities", key = "#result.id")
    public MyEntity save(MyEntity entity) {
        return repository.save(entity);
    }

    @CacheEvict("entities")
    public void delete(Long id) {
        repository.delete(id);
    }

    @Cacheable("entities")
    public MyEntity findOne(Long id) {
        return repository.findOne(id);
    }

    public Iterable<MyEntity> findAll() {
        return repository.findAll();
    }
}
