package com.muatik.service;

import com.muatik.model.MyEntity;
import com.muatik.repository.MyEntityRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by mustafaatik on 20/01/17.
 */
@Service
public class MyEntityService {

    private Logger logger = Logger.getLogger(this.getClass());

    private MyEntityRepository repository;

    public MyEntityService(MyEntityRepository repository) {
        this.repository = repository;
    }

    public Iterable<MyEntity> findAll() {
        logger.warn("finding all in database");
        return repository.findAll();
    }

    @Cacheable("entities")
    public Optional<MyEntity> findOne(Long id) {
        return findOneInDatabase(id);
    }

    @CachePut(value = "entities", key = "#result.id")
    public MyEntity save(MyEntity entity) {
        logger.warn("saving " + entity.getId() + " to database");
        return repository.save(entity);
    }

    @CacheEvict("entities")
    public void delete(long id) {
        logger.warn("deleting " + id);
        repository.delete(id);
    }

    public Optional<MyEntity> findOneInDatabase(long id) {
        logger.warn("finding " + id + " in database");
        return Optional.ofNullable(repository.findOne(id));
    }
}
