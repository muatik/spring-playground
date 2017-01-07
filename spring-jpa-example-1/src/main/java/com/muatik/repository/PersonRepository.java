package com.muatik.repository;

import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.muatik.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by muatik on 1/7/17.
 */

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
    Iterable<Person> findAllByHeight(float height);
    Iterable<Person> findAllByOrderByHeightDesc();
}
