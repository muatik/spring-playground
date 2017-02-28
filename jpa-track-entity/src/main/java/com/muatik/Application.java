package com.muatik;

import com.muatik.model.Book;
import com.muatik.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mustafaatik on 06/01/17.
 */
@RestController
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    BookService service;

    @Bean
    CommandLineRunner commandLineRunner () {
        return (args -> {
            Book b1 = new Book();
            Book b2 = new Book();
            b1.setTitle("b1");
            b2.setTitle("b2");

            service.save(b1);
            service.save(b2);

            b1.setTitle("b11");
            b2.setTitle("b22");

            service.save(b2);
            // this save operation WILL NOT causes that b2 will also be saved alongside b1
            logger.warn(b1.getTitle() + "," + b2.getTitle());
        });

    }

    @GetMapping
    public String get() {
        Book b1 = new Book();
        Book b2 = new Book();
        b1.setTitle("b1");
        b2.setTitle("b2");

        service.save(b1);
        service.save(b2);

        b1.setTitle("b11");
        b2.setTitle("b22");

        service.save(b2);
        // this save operation causes that b2 will also be saved alongside b1
        return b1.getTitle() + "," + b2.getTitle();
    }
}
