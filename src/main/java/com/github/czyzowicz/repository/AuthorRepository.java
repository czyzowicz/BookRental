package com.github.czyzowicz.repository;

import com.github.czyzowicz.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Set<Author> findAllBy();
}
