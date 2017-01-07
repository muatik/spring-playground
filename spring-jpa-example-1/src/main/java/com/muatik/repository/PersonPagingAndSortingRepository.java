package com.muatik.repository;

import com.muatik.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by muatik on 1/7/17.
 */
public interface PersonPagingAndSortingRepository extends PagingAndSortingRepository<Person, Long>{
}
