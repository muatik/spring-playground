package com.muatik.service;

import com.muatik.model.BlogPost;
import com.muatik.repository.PostRepository;
import org.slf4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by mustafaatik on 25/01/17.
 */
@Service
public class PostService {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    private PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    @CachePut(value = "posts", key = "#result.id")
    public BlogPost save(BlogPost entity) {
        logger.debug("service.save() is called");
        return repository.save(entity);
    }

    @CacheEvict("posts")
    public void delete(long id) {
        logger.debug("service.delete() is called");
        repository.delete(id);
    }

    @Cacheable("posts")
    public BlogPost findOne(long id) {
        logger.debug("service.findOne() is called");
        return repository.findOne(id);
    }

    public Iterable<BlogPost> findAll() {
        logger.debug("service.findAll() is called");
        return repository.findAll();
    }

    public BlogPost findOneInDB(long id) {
        return repository.findOne(id);
    }
}
