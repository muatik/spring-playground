package com.test.repositories;

import com.test.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 23/12/16.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findOneByEmail(String email);
}
