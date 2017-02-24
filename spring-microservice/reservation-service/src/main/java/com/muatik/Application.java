package com.muatik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.stream.Stream;

/**
 * Created by mustafaatik on 24/02/2017.
 */
@SpringBootApplication
public class Application {



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner (ReservationRepository repository) {
        return args -> {
            Stream.of("mustafa", "ali", "burak", "can", "donr")
                    .forEach(n -> repository.save(new Reservation(n)));
        };
    }


}

@RefreshScope
@RestController
class Controller{

    @Autowired
    ReservationRepository repository;

    @GetMapping("/")
    public Iterable<Reservation> get() {
        return repository.findAll();
    }

    @Value("${message}")
    private String message;

    @GetMapping("/message/")
    public String getMessage() {
        return message;
    }
}

@Repository
interface ReservationRepository extends CrudRepository<Reservation, Long> {

}

@Entity
class Reservation {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Reservation() {}

    public Reservation(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
