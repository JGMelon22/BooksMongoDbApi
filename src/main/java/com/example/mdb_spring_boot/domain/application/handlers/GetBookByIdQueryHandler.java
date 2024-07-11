package com.example.mdb_spring_boot.domain.application.handlers;

import com.example.mdb_spring_boot.domain.model.Book;
import com.example.mdb_spring_boot.domain.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class GetBookByIdQueryHandler {
    private final BookService bookService;

    public GetBookByIdQueryHandler(BookService bookService) {
        this.bookService = bookService;
    }

    public Book getBookById(String id) {
        return bookService.findById(id);
    }
}
