package com.muatik.repository;

import com.muatik.model.MyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 26/01/17.
 */

@Repository
public interface MyEntityRepository extends CrudRepository<MyEntity, Long>{
}
