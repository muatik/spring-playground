package com.muatik.repository;

import com.muatik.model.PollOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 04/01/17.
 */
@Repository
public interface PollRepository extends CrudRepository<PollOption, Long>{
}
