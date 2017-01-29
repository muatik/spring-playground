package com.muatik.repository;

import com.muatik.model.PostComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by muatik on 1/29/17.
 */
@Repository
public interface PostCommentsRepository extends CrudRepository<PostComment, Long>{
}
