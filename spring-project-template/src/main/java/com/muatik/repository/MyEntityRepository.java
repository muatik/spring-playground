package com.muatik.repository;

import com.muatik.model.MyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by muatik on 12/31/16.
 */
@Repository
public interface MyEntityRepository extends CrudRepository<MyEntity, Long>{
}
