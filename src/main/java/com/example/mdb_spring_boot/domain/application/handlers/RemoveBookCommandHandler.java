package com.example.mdb_spring_boot.domain.application.handlers;

import com.example.mdb_spring_boot.domain.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class RemoveBookCommandHandler {
    private final BookService bookService;

    public RemoveBookCommandHandler(BookService bookService) {
        this.bookService = bookService;
    }

    public void removeBook(String id) {
        bookService.delete(id);
    }
}
