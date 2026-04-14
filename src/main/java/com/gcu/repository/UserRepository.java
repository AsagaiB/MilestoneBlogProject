package com.gcu.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

}