package com.muatik.repository;

import com.muatik.model.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by muatik on 1/11/17.
 */

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long>{
}
