package com.muatik.ManyToOne.repository;

import com.muatik.ManyToOne.model.Comment;
import com.muatik.ManyToOne.model.Post;
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
