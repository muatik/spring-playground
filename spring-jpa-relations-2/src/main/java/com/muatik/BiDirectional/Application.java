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
//            Hibernate: insert into post (title) values (?)
//            Hibernate: insert into comment (author, post_id, text) values (?, ?, ?)

            service.deletePost(post1.getId());
//            Hibernate: select post0_.id as id1_1_0_, post0_.title as title2_1_0_ from post post0_ where post0_.id=?
//            Hibernate: select comments0_.post_id as post_id4_0_0_, comments0_.id as id1_0_0_, comments0_.id as id1_0_1_, comments0_.author as author2_0_1_, comments0_.post_id as post_id4_0_1_, comments0_.text as text3_0_1_ from comment comments0_ where comments0_.post_id=?
//            Hibernate: delete from comment where id=?
//            Hibernate: delete from post where id=?

            service.savePost(post1);
//            Hibernate: select post0_.id as id1_1_1_, post0_.title as title2_1_1_, comments1_.post_id as post_id4_0_3_, comments1_.id as id1_0_3_, comments1_.id as id1_0_0_, comments1_.author as author2_0_0_, comments1_.post_id as post_id4_0_0_, comments1_.text as text3_0_0_ from post post0_ left outer join comment comments1_ on post0_.id=comments1_.post_id where post0_.id=?
//            Hibernate: insert into post (title) values (?)
//            Hibernate: select comment0_.id as id1_0_0_, comment0_.author as author2_0_0_, comment0_.post_id as post_id4_0_0_, comment0_.text as text3_0_0_ from comment comment0_ where comment0_.id=?
//            Hibernate: insert into comment (author, post_id, text) values (?, ?, ?)

            Comment comment2_1 = new Comment("comment 2", "author2", post1);
            post1.addComment(comment2_1);

            service.savePost(post1);
//            Hibernate: select post0_.id as id1_1_1_, post0_.title as title2_1_1_, comments1_.post_id as post_id4_0_3_, comments1_.id as id1_0_3_, comments1_.id as id1_0_0_, comments1_.author as author2_0_0_, comments1_.post_id as post_id4_0_0_, comments1_.text as text3_0_0_ from post post0_ left outer join comment comments1_ on post0_.id=comments1_.post_id where post0_.id=?
//            Hibernate: insert into post (title) values (?)
//            Hibernate: select comment0_.id as id1_0_0_, comment0_.author as author2_0_0_, comment0_.post_id as post_id4_0_0_, comment0_.text as text3_0_0_ from comment comment0_ where comment0_.id=?
//            Hibernate: insert into comment (author, post_id, text) values (?, ?, ?)
//            Hibernate: insert into comment (author, post_id, text) values (?, ?, ?)

            Post post4 = new Post("4rd post");
            Comment comment41= new Comment("comment 41", "author2", post4);
            Comment comment42 = new Comment("comment 42", "author2", post4);
            post4.addComment(comment41);
            post4.addComment(comment42);
            service.savePost(post4);
//            Hibernate: insert into post (title) values (?)
//            Hibernate: insert into comment (author, post_id, text) values (?, ?, ?)
//            Hibernate: insert into comment (author, post_id, text) values (?, ?, ?)

            post4.addComment(new Comment("comment 43", "author2", post4));
            post4 = service.savePost(post4);

            post4.deleteComment(comment42);
            service.savePost(post4);
        };
    }

}
