package com.github.czyzowicz.service;

import com.github.czyzowicz.dto.BookDto;
import com.github.czyzowicz.model.Book;

import java.util.Set;

public interface BookService {

    void create (String title, Long authorId);
    Set<BookDto> findAll();
    Set<BookDto> findAllByAuthorId(Long id);
    }
