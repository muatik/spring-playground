package com.muatik.service;

import com.muatik.model.BlogPost;

import java.util.Optional;

/**
 * Created by muatik on 1/29/17.
 */

public interface MyEntityService {
    Optional<BlogPost> findOne(long id);
    Iterable<BlogPost> findAll();
    BlogPost save(BlogPost entity);
    void delete(long id);
}
