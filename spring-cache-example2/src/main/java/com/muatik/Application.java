package com.muatik;

import com.muatik.model.BlogPost;
import com.muatik.model.PostComment;
import com.muatik.service.PostService;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.assertEquals;

/**
 * Created by mustafaatik on 25/01/17.
 */

@SpringBootApplication
@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private final Logger logger = Logger.getLogger(this.getClass());

    @Bean
    public CommandLineRunner command(PostService service) {
        return (args) -> {
            logger.warn("saving an post");
            BlogPost post1 = new BlogPost("mustafa");
            service.save(post1);

            logger.warn("finding the post");
            assertEquals(service.findOne(post1.getId()).getTitle(), post1.getTitle());

            logger.warn("finding the post in db");
            assertEquals(service.findOneInDB(post1.getId()).getTitle(), post1.getTitle());

            logger.warn("updating the post");
            post1.setTitle("muatik");
            service.save(post1);

            logger.warn("finding the updated post");
            assertEquals(service.findOne(post1.getId()).getTitle(), post1.getTitle());

            logger.warn("deleting the entry");
            service.delete(post1.getId());

            logger.warn("finding the deleted entry");
            service.findOne(post1.getId());

            BlogPost post = new BlogPost("a title");
            post.addComment(new PostComment("1st comment"));
            post.addComment(new PostComment("2nd comment"));
            service.save(post);

            assertEquals(service.findOne(post.getId()).getComments().size(), 2);
            assertEquals(service.findOne(post.getId()).getComments().get(1).getComment(), "2nd comment");

            post.addComment(new PostComment("3rd comment"));
            service.save(post);
            post = service.findOne(post.getId());
            assertEquals(service.findOne(post.getId()).getComments().size(), 3);

        };
    }

}
