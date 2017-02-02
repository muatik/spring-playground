package com.muatik.ManyToOne.repository;

import com.muatik.ManyToOne.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 01/02/2017.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
}
