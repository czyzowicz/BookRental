package com.github.czyzowicz.repository;

import com.github.czyzowicz.security.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByLogin (String login);

}
