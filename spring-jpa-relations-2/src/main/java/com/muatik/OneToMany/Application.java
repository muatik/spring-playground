package com.muatik.OneToMany;

import com.muatik.OneToMany.model.Comment;
import com.muatik.OneToMany.model.Post;
import com.muatik.OneToMany.service.BlogService;
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

            Comment comment1_1 = new Comment("comment 11", "author11");
            Comment comment1_2 = new Comment("comment 22", "author22");

            post1.getComments().add(comment1_1);
            post1.getComments().add(comment1_2);

            // saving post as well as comments; and associating comments to post
            service.savePost(post1);

            // deleting post as well as associated comments
            service.deletePost(post1.getId());

//            Hibernate: insert into post (title) values (?)
//            Hibernate: insert into comment (author, text) values (?, ?)
//            Hibernate: insert into comment (author, text) values (?, ?)
//            Hibernate: insert into post_comments (post_id, comments_id) values (?, ?)
//            Hibernate: insert into post_comments (post_id, comments_id) values (?, ?)

//            Hibernate: select post0_.id as id1_1_0_, post0_.title as title2_1_0_ from post post0_ where post0_.id=?
//            Hibernate: select comments0_.post_id as post_id1_2_0_, comments0_.comments_id as comments2_2_0_, comment1_.id as id1_0_1_, comment1_.author as author2_0_1_, comment1_.text as text3_0_1_ from post_comments comments0_ inner join comment comment1_ on comments0_.comments_id=comment1_.id where comments0_.post_id=?
//            Hibernate: delete from post_comments where post_id=?
//            Hibernate: delete from comment where id=?
//            Hibernate: delete from comment where id=?
//            Hibernate: delete from post where id=?
        };
    }

}
