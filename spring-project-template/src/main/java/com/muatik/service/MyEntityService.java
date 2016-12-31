package com.muatik.service;

import com.muatik.model.MyEntity;

import java.util.Optional;

/**
 * Created by muatik on 12/31/16.
 */
public interface MyEntityService {
    Optional<MyEntity> findOne(long id);
    Iterable<MyEntity> findAll();
    MyEntity save(MyEntity entity);
    void delete(long id);
}
