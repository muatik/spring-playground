package com.muatik.repository;

import com.muatik.model.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 25/01/17.
 */

@Repository
public interface PostRepository extends CrudRepository<BlogPost, Long>{
}
