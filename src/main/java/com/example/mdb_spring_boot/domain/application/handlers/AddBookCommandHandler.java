package com.example.mdb_spring_boot.domain.application.handlers;

import com.example.mdb_spring_boot.api.dto.BookDto;
import com.example.mdb_spring_boot.domain.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class AddBookCommandHandler {
    private final BookService bookService;

    public AddBookCommandHandler(BookService bookService) {
        this.bookService = bookService;
    }

    public void addNewBook(BookDto newBook) {
        bookService.save(newBook);
    }
}
