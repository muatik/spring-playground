package com.muatik.BiDirectional;

import com.muatik.BiDirectional.model.Comment;
import com.muatik.BiDirectional.model.Post;
import com.muatik.BiDirectional.service.BlogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by mustafaatik on 01/02/2017.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner command(BlogService service) {
        return (args) -> {
            Post post1 = new Post("first post");

            Comment comment1_1 = new Comment("comment 1", "author1", post1);
            post1.addComment(comment1_1);
            service.savePost(post1);
            service.deletePost(post1.getId());

//            Hibernate: insert into post (title) values (?)
//            Hibernate: insert into comment (author, post_id, text) values (?, ?, ?)
//            Hibernate: select post0_.id as id1_1_0_, post0_.title as title2_1_0_ from post post0_ where post0_.id=?
//            Hibernate: select comments0_.post_id as post_id4_0_0_, comments0_.id as id1_0_0_, comments0_.id as id1_0_1_, comments0_.author as author2_0_1_, comments0_.post_id as post_id4_0_1_, comments0_.text as text3_0_1_ from comment comments0_ where comments0_.post_id=?
//            Hibernate: delete from comment where id=?
//            Hibernate: delete from post where id=?

            service.savePost(post1);

            Comment comment2_1 = new Comment("comment 2", "author2", post1);
            post1.addComment(comment2_1);

            service.savePost(post1);

        };
    }

}
