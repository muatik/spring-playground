package com.muatik.OneToMany.repository;

import com.muatik.OneToMany.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 01/02/2017.
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
}
