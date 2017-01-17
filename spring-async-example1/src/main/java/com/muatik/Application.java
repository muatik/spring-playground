package com.muatik;

import com.muatik.repository.MyEntityRepository;
import com.muatik.service.MyEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mustafaatik on 17/01/17.
 */

@SpringBootApplication
@RestController
//@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private MyEntity service;

    @Bean
    public CommandLineRunner command(MyEntityRepository repository) {
        return (args) -> {
            repository.findAll();
        };
    }

    public Application(MyEntity service) {
        this.service = service;
    }


    @GetMapping(value = "/api/something/")
    public String getSomething(@RequestParam("sleep") long sleep) {
        service.doSomethingSlow(sleep);
        return "ok";
    }


}
