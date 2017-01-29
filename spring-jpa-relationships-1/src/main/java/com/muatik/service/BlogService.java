package com.muatik.service;

import com.muatik.model.BlogPost;
import com.muatik.model.PostComment;
import com.muatik.repository.PostCommentsRepository;
import com.muatik.repository.PostsRepository;
import org.springframework.stereotype.Service;

/**
 * Created by muatik on 1/29/17.
 */
@Service
public class BlogService {
    private PostsRepository postsRepository;
    private PostCommentsRepository commentsRepository;

    public BlogService(PostsRepository postsRepository, PostCommentsRepository commentsRepository) {
        this.postsRepository = postsRepository;
        this.commentsRepository = commentsRepository;
    }

    public BlogPost savePost(BlogPost post) {
        return postsRepository.save(post);
    }

    public void delete(Long id) {
        postsRepository.delete(id);
    }

    public BlogPost findOnePost(Long id) {
        return postsRepository.findOne(id);
    }

    public Iterable<BlogPost> findAllPosts() {
        return postsRepository.findAll();
    }

    public PostComment saveComment(PostComment comment) {
        return commentsRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentsRepository.delete(id);
    }

    public PostComment findOneComment(Long id) {
        return commentsRepository.findOne(id);
    }

    public Iterable<BlogPost> findCommentsByPost(Long id) {
        return postsRepository.findAll();
    }
}
