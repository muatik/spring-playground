package com.muatik;

import com.muatik.model.MyEntity;
import com.muatik.repository.MyEntityRepository;
import com.muatik.service.MyEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by mustafaatik on 26/01/17.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner command(MyEntityService service, RedisTemplate redisTemplate) {
        return (args) -> {
            MyEntity entity = new MyEntity("e1");
            service.save(entity);
            service.findOne(entity.getId());

            entity.setName("e11");
            service.findOne(entity.getId());

//            redisTemplate.opsForValue().get("elma");
        };
    }

}
