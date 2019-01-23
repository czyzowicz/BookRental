package com.github.czyzowicz.repository;

import com.github.czyzowicz.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Set<Book> findAllBy ();
    Set<Book> findAllByAuthorId(Long authorId);
    Set<Book> findAllByIdIn(Set<Long> ids);
}