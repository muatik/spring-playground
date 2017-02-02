package com.muatik.OneToMany.service;

import com.muatik.OneToMany.model.Comment;
import com.muatik.OneToMany.model.Post;
import com.muatik.OneToMany.repository.CommentRepository;
import com.muatik.OneToMany.repository.PostRepository;
import org.springframework.stereotype.Service;


/**
 * Created by mustafaatik on 01/02/2017.
 */
@Service
public class BlogService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public BlogService(PostRepository postRepository, CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }




    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(long id) {
        postRepository.delete(id);
    }

    public Post findOnePost(long id) {
        return postRepository.findOne(id);
    }





    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(long id) {
        commentRepository.delete(id);
    }

    public Comment findOneComment(long id) {
        return commentRepository.findOne(id);
    }





}
