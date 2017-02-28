package com.muatik.repository;

import com.muatik.model.MyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 06/02/2017.
 */

@Repository
public interface MyEntityRepository extends CrudRepository<MyEntity, Long>{
}
