package com.muatik.repository;

import com.muatik.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 03/01/17.
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
