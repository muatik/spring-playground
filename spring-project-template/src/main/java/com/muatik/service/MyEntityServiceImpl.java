package com.muatik.service;

import com.muatik.model.MyEntity;
import com.muatik.repository.MyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by muatik on 12/31/16.
 */
@Service
public class MyEntityServiceImpl implements MyEntityService{

    @Autowired
    MyEntityRepository repository;

    @Override
    public Optional<MyEntity> findOne(long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    public Iterable<MyEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public MyEntity save(MyEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
