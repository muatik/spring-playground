package com.muatik.integrationtest.repository;

import com.muatik.integrationtest.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 30/12/16.
 */
@Repository
public interface UserRepository extends CrudRepository<Book, Long>{
}
