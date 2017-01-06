package com.muatik.repository;

import com.muatik.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.sql.rowset.CachedRowSet;

/**
 * Created by mustafaatik on 06/01/17.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
}
