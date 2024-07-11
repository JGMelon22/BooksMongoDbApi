package com.example.mdb_spring_boot.domain.application.handlers;

import com.example.mdb_spring_boot.domain.model.Book;
import com.example.mdb_spring_boot.domain.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBooksQueryHandler {
    private final BookService bookService;

    public GetBooksQueryHandler(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Book> getAllBooks() {
        return bookService.listAll();
    }
}
