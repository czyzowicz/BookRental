package com.github.czyzowicz.service.impl;

import com.github.czyzowicz.model.Address;
import com.github.czyzowicz.model.Author;
import com.github.czyzowicz.repository.AddressRepository;
import com.github.czyzowicz.repository.AuthorRepository;
import com.github.czyzowicz.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private AddressRepository addressRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void create(String firstName, String lastName, Long addressId) {

        Address address = addressRepository.findOne(addressId);

        Author author = new Author();
        author.setAddress(address);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
    }

    @Override
    public Set<Author> findAll() {
        return authorRepository.findAllBy();
    }
}