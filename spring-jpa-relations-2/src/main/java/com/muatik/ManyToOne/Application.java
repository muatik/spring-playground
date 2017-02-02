package com.muatik.ManyToOne;

import com.muatik.ManyToOne.model.Comment;
import com.muatik.ManyToOne.model.Post;
import com.muatik.ManyToOne.service.BlogService;
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
            service.savePost(post1);

            Comment comment1_1 = new Comment("comment 1", "author1", post1);
            Comment comment1_2 = new Comment("comment 1", "author1", post1);
            service.saveComment(comment1_1);
            service.saveComment(comment1_2);

            service.deleteCommentsByPost(post1);

//            Hibernate: insert into post (title) values (?)
//            Hibernate: insert into comment (author, post_id, text) values (?, ?, ?)
//            Hibernate: insert into comment (author, post_id, text) values (?, ?, ?)

//            Hibernate: select comment0_.id as id1_0_, comment0_.author as author2_0_, comment0_.post_id as post_id4_0_, comment0_.text as text3_0_ from comment comment0_ left outer join post post1_ on comment0_.post_id=post1_.id where post1_.id=?
//            Hibernate: select post0_.id as id1_1_0_, post0_.title as title2_1_0_ from post post0_ where post0_.id=?
//            Hibernate: update comment set author=?, post_id=?, text=? where id=?
//            Hibernate: delete from comment where id=?
//            Hibernate: delete from post where id=?
//            Hibernate: delete from comment where id=?

        };
    }

}
