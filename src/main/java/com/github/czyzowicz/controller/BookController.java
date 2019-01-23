package com.github.czyzowicz.controller;

import com.github.czyzowicz.dto.BookDto;
import com.github.czyzowicz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/books")
public class BookController  {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void create (@RequestParam Long authorId, @RequestParam String title){
        bookService.create(title, authorId);
    }

    @GetMapping
    public Set<BookDto> findAll () {
        return bookService.findAll();
    }
}
