package com.example.mdb_spring_boot.service;

import com.example.mdb_spring_boot.dto.BookDto;
import com.example.mdb_spring_boot.model.Book;
import com.example.mdb_spring_boot.mapper.BookMapper;
import com.example.mdb_spring_boot.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookService(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public Book findById(String id) {
        Optional<Book> book0 = bookRepository.findById(id);

        if(book0.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Book with id \"%s\" not found", id));

        return book0.get();
    }

    public void save(BookDto newBook) {
        Book book = bookMapper.bookEntity(newBook);
        bookRepository.save(book);
    }

    public Book update(String id, BookDto updatedBook) {
        Optional<Book> book0 = bookRepository.findById(id);
        if(book0.isPresent()) {
            Book book = book0.get();
            bookMapper.updateBook(updatedBook, book);
            return bookRepository.save(book);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Book with id \"%s\" not found", id));
    }

    public void delete(String id) {
        Optional<Book> book0 = bookRepository.findById(id);
        if(book0.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Book with id \"%s\" not found", id));

        bookRepository.delete(book0.get());
    }
}
