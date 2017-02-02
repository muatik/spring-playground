package com.muatik.BiDirectional.repository;

import com.muatik.BiDirectional.model.Comment;
import com.muatik.BiDirectional.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by mustafaatik on 01/02/2017.
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
    Iterable<Comment> findAllByPost(long postId);

    @Transactional
    void deleteByPost(Post post);
}
