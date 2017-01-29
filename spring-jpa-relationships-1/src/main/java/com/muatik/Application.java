package com.muatik;

import com.muatik.model.BlogPost;
import com.muatik.model.PostComment;
import com.muatik.service.BlogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by muatik on 1/29/17.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BlogService blogService) {
        return (args -> {
            BlogPost post1 = new BlogPost("a post about bears");
            post1 = blogService.savePost(post1);
            post1 = blogService.savePost(post1);

//            PostComment comment11 = new PostComment("that bear is ugly");
//            PostComment comment12 = new PostComment("nope, imho, that bear is cool.");
//            post1 = blogService.findOnePost(1l);
//            comment11.setPost(post1);
//            blogService.saveComment(comment11);
//
////            comment12.setPost(comment11.getPost());
////            blogService.saveComment(comment12);
//
//            blogService.findOneComment(comment11.getId());
        });
    }

}
