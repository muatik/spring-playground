package com.muatik;

import com.muatik.model.MyEntity;
import com.muatik.service.MyEntityService;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.assertEquals;


/**
 * Created by mustafaatik on 20/01/17.
 */

@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private final Logger logger = Logger.getLogger(this.getClass());

    @Bean
    public CommandLineRunner command(MyEntityService service) {
        return (args) -> {
            MyEntity e1 = new MyEntity("mustafa");

            service.save(e1);  // will cause insert sql statement and insert into both cache and database
            assertEquals(
                    e1.getName(), service.findOne(e1.getId()).get().getName());// will come from cache



            logger.warn("entity name is getting renamed");
            e1.setName("ali");
            service.save(e1); // cache will be updated

            assertEquals(
                    "ali", service.findOne(e1.getId()).get().getName());// will come from cache

            assertEquals(
                    "ali", service.findOneInDatabase(e1.getId()).get().getName());// will come from database



            logger.warn("entity name is getting deleted");
            service.delete(e1.getId()); // cache will be evicted
            logger.warn("entity name is deleted. trying to find it");
            assertEquals(false, service.findOne(e1.getId()).isPresent()); // expected to be not present, cause sql statement
            logger.warn("entity name is deleted. trying to find it in database");
            assertEquals(false, service.findOneInDatabase(e1.getId()).isPresent()); // not present, cause sql statement


            logger.warn("a new entity is being inserted");
            e1 = new MyEntity("neval");
            service.save(e1);
            assertEquals(
                    e1.getName(), service.findOne(e1.getId()).get().getName());// will come from cache

            assertEquals(
                    e1.getName(), service.findOneInDatabase(e1.getId()).get().getName());// will come from cache

        };
    }

}
