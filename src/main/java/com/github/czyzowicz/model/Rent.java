package com.github.czyzowicz.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Rent_Book",
            joinColumns = { @JoinColumn(name = "rent_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") } )
    private Set<Book> books = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
