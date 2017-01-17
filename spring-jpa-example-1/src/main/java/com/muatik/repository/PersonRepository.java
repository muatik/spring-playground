package com.muatik.repository;

import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.muatik.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by muatik on 1/7/17.
 */

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
    Iterable<Person> findAllByHeight(float height);
    Iterable<Person> findAllByOrderByHeightDesc();
    Iterable<Person> findByAddress_Country(String country);

    // will cause an extra count query
    Page<Person> findAllByAddress_Country(String country, Pageable pageable);

    // however, this does not need to count
    List<Person> findAllWithoutCountByAddress_Country(String country, Pageable pageable);

    Slice<Person> findAllByHeight(float height, Pageable pageable);

    Person findTopByOrderByHeightDesc();

    List<Person> findTop3ByOrderByHeightDesc();
}
