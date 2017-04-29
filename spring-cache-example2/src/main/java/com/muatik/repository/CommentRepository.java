package com.muatik.repository;

import com.muatik.model.PostComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 25/01/17.
 */
@Repository
public interface CommentRepository extends CrudRepository<PostComment, Long>{
}
