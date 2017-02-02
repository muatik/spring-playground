package com.muatik.OneToMany.repository;

import com.muatik.OneToMany.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 01/02/2017.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
}
