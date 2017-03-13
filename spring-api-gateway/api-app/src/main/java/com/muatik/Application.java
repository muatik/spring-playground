package com.muatik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mustafaatik on 13/03/2017.
 */
@SpringBootApplication
@RestController
public class Application {

    @Autowired
    SongRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            repository.save(new Song("hello world"));
            repository.save(new Song("bye bye world"));
        };
    }

    @GetMapping("/songs/")
    public  Iterable<Song> getSongs() {
        return repository.findAll();
    }

    @PostMapping("/songs/")
    public Song saveSong(@RequestBody Song song) {
        return repository.save(song);
    }

    @DeleteMapping("/songs/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveSong(@PathVariable long id) {
        repository.delete(id);
    }
}

@Entity
class Song {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    public Song() {}
    public Song(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


@Repository
interface SongRepository extends CrudRepository<Song, Long> {}

