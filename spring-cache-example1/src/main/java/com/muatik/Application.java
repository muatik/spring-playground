package com.muatik;

import com.muatik.repository.MyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * Created by mustafaatik on 20/01/17.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    RedisTemplate redisTemplate;

    @Bean
    public CommandLineRunner command(MyEntityRepository repository) {
        return (args) -> {

            System.out.println(redisTemplate.opsForValue().get("elma"));
            repository.findAll();
        };
    }

}
