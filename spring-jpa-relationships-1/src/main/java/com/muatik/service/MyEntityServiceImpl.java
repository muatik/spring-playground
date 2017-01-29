package com.muatik.service;

import com.muatik.model.BlogPost;
import com.muatik.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by muatik on 1/29/17.
 */

@Service
public class MyEntityServiceImpl implements MyEntityService{

    @Autowired
    PostsRepository repository;

    @Override
    public Optional<BlogPost> findOne(long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    public Iterable<BlogPost> findAll() {
        return repository.findAll();
    }

    @Override
    public BlogPost save(BlogPost entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
