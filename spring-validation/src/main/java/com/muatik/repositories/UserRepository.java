package com.muatik.repositories;

import com.muatik.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mustafaatik on 26/12/16.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findOneByEmail(String email);
}
