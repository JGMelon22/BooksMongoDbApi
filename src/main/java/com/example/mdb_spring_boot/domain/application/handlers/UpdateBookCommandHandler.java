package com.example.mdb_spring_boot.domain.application.handlers;

import com.example.mdb_spring_boot.api.dto.BookDto;
import com.example.mdb_spring_boot.domain.model.Book;
import com.example.mdb_spring_boot.domain.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookCommandHandler {
    private final BookService bookService;

    public UpdateBookCommandHandler(BookService bookService) {
        this.bookService = bookService;
    }

    public Book updateBook(String id, BookDto updatedBook) {
        return bookService.update(id, updatedBook);
    }
}
