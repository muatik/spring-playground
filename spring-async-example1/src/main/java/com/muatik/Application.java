package com.muatik;

import com.muatik.repository.MyEntityRepository;
import com.muatik.service.MyEntity;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mustafaatik on 17/01/17.
 */

@SpringBootApplication
@RestController
@EnableAsync // if this annotation is omitted, after reaching to server.tomcat.max-threads value,
            // no more request will not be handled.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private MyEntity service;

    @Bean
    @Qualifier("somethingExecutor")
    public ThreadPoolTaskExecutor createThreadPoolTaskExecutor_something() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3); // 3 thread will be kept alive and ready
        executor.setMaxPoolSize(5); // at most 5 threads will be running
        return executor;
    }

    @Bean
    @Qualifier("emailSender")
    public ThreadPoolTaskExecutor createThreadPoolTaskExecutor_email() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(3);
        return executor;
    }

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
    public String getSomething(@RequestParam("id") String id, @RequestParam("sleep") long sleep) {
        service.doSomethingSlow(id, sleep);
        return "queued.";
    }

    @GetMapping(value = "/api/email/")
    public String sendEmail(@RequestParam("id") String id, @RequestParam("sleep") long sleep) {
        service.sendEmail(id, sleep);
        return "queued.";
    }

}
