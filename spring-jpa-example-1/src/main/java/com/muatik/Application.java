package com.muatik;

import com.muatik.model.Address;
import com.muatik.model.Person;
import com.muatik.repository.PersonPagingAndSortingRepository;
import com.muatik.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


/**
 * Created by muatik on 1/7/17.
 */

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    PersonPagingAndSortingRepository personPagingAndSortingRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner populateDB(PersonRepository repository) {
        return (args) -> {
            repository.deleteAll();

            repository.save(new Person(75, "mustafa", "atik", new Address("Istanbul", "Turkey")));
            repository.save(new Person(74, "john", "smith", new Address("San Francisco", "US")));
            repository.save(new Person(71, "jane", "cate", new Address("London", "United Kingdom")));
            repository.save(new Person(73, "neval", "uysal", new Address("Istanbul", "Turkey")));
            repository.save(new Person(75, "micheal", "bourbone", new Address("San Francisco", "US")));
            repository.save(new Person(81, "mateo", "senza", new Address("Rome", "Italy")));
            repository.save(new Person(79, "mehmet", "yilmaz", new Address("Istanbul", "Turkey")));
            repository.save(new Person(72, "sinan", "sar", new Address("Istanbul", "Turkey")));
            repository.save(new Person(71, "Alice", "Ben", new Address("London", "UK")));
            repository.save(new Person(75, "Frank", "Ropourt", new Address("London", "UK")));

            logger.info("");
            logger.info("Count: " + repository.count());

            repository.findAllByHeight(71).forEach(Application::printPerson);

            logger.info("== second page with page size 4 ==");
            personPagingAndSortingRepository.findAll(new PageRequest(1, 4))
                    .forEach(Application::printPerson);

            logger.info("== order by height descending ==");
            repository.findAllByOrderByHeightDesc().forEach(Application::printPerson);

            logger.info("== filter by country=US ==");
            repository.findByAddress_Country("US").forEach(Application::printPerson);

            logger.info("== filter with pageable by country=Turkey ==");
            // will caouse an extra query to count to calculate available pages
            repository.findAllByAddress_Country("Turkey", new PageRequest(0, 2))
                    .forEach(Application::printPerson);

            logger.info("== filter with pageable without counting by country=Turkey ==");
            repository.findAllWithoutCountByAddress_Country("Turkey", new PageRequest(0, 2))
                    .forEach(Application::printPerson);

            logger.info("== findAllByHeight with slices ==");
            repository.findAllByHeight(75, new PageRequest(0, 1))
                    .forEach(Application::printPerson);

            logger.info("== the tallest person ==");
            printPerson(repository.findTopByOrderByHeightDesc());

            logger.info("== the tallest 3 person ==");
            repository.findTop3ByOrderByHeightDesc().forEach(Application::printPerson);
        };
    }

    private static void printPerson(Person person) {
        logger.info(person.toString());
    }
}
