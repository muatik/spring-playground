package com.muatik;

import com.muatik.repository.MyEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mustafaatik on 06/02/2017.
 */
@SpringBootApplication
@RestController
public class Application {

    private final static Logger logger = LoggerFactory.getLogger(Application.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner command(MyEntityRepository repository) {
        return (args) -> {
            logger.error("error happened", new Exception("yeap it occurred."));
            logger.info("info");
            logger.warn("warning name: {} ", "warnnnn");
            logger.error("error");
        };
    }

    @GetMapping("/")
    public void loggg() {
        logger.error("error happened", new Exception("yeap it occurred."));
        logger.info("info");
        logger.warn("warning name: {} ", "warnnnn");
        logger.error("error");
    }

}
