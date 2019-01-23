package com.github.czyzowicz.service;

import com.github.czyzowicz.model.Author;

import java.util.Set;

public interface AuthorService {

    void create(String firstName, String lastName, Long addressId);
    Set<Author> findAll();
}