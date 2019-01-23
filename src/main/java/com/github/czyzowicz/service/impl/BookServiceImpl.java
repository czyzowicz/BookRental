package com.github.czyzowicz.service.impl;

import com.github.czyzowicz.dto.BookDto;
import com.github.czyzowicz.model.Book;
import com.github.czyzowicz.repository.AuthorRepository;
import com.github.czyzowicz.repository.BookRepository;
import com.github.czyzowicz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void create(String title, Long authorId) {
        Book book = new Book();
        book.setAuthor(authorRepository.findOne(authorId));
        book.setTitle(title);
        bookRepository.save(book);
    }

    @Override
    public Set<BookDto> findAll() {
        return bookRepository.findAllBy ().stream().map(BookDto::new).collect(Collectors.toSet());
    }

    @Override
    public Set<BookDto> findAllByAuthorId(Long id) {
        return bookRepository.findAllByAuthorId(id).stream().map(book -> new BookDto(book)).collect(Collectors.toSet());
    }
}
