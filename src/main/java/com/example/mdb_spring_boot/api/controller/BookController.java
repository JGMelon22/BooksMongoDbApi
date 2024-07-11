package com.example.mdb_spring_boot.api.controller;

import com.example.mdb_spring_boot.api.dto.BookDto;
import com.example.mdb_spring_boot.domain.application.handlers.*;
import com.example.mdb_spring_boot.domain.model.Book;
import com.example.mdb_spring_boot.domain.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final GetBooksQueryHandler getBooksQueryHandler;
    private final GetBookByIdQueryHandler bookByIdQueryHandler;
    private final AddBookCommandHandler addBookCommandHandler;
    private final UpdateBookCommandHandler updateBookCommandHandler;
    private final RemoveBookCommandHandler removeBookCommandHandler;

    public BookController(GetBooksQueryHandler getBooksQueryHandler, GetBookByIdQueryHandler bookByIdQueryHandler, AddBookCommandHandler addBookCommandHandler, UpdateBookCommandHandler updateBookCommandHandler, RemoveBookCommandHandler removeBookCommandHandler) {
        this.getBooksQueryHandler = getBooksQueryHandler;
        this.bookByIdQueryHandler = bookByIdQueryHandler;
        this.addBookCommandHandler = addBookCommandHandler;
        this.updateBookCommandHandler = updateBookCommandHandler;
        this.removeBookCommandHandler = removeBookCommandHandler;
    }


    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = getBooksQueryHandler.getAllBooks();
        return books.isEmpty()
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") String id) {
        Book book = bookByIdQueryHandler.getBookById(id);
        return book != null
                ? ResponseEntity.status(HttpStatus.OK).body(book)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping()
    public ResponseEntity<Book> saveBook(@RequestBody @Valid BookDto bookDto) {
        addBookCommandHandler.addNewBook(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid BookDto bookDto) {
        Book book = bookByIdQueryHandler.getBookById(id);
        return book != null
                ? ResponseEntity.status(HttpStatus.OK).body(updateBookCommandHandler.updateBook(id, bookDto))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable(value = "id") String id) {
        if (id == null || id.isEmpty())
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        removeBookCommandHandler.removeBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
