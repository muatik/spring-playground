package com.muatik.repository;

import com.muatik.model.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by muatik on 1/29/17.
 */

@Repository
public interface PostsRepository extends CrudRepository<BlogPost, Long>{
}
