package com.example.mdb_spring_boot.domain.service;

import com.example.mdb_spring_boot.domain.model.Book;
import com.example.mdb_spring_boot.api.dto.BookDto;
import com.example.mdb_spring_boot.domain.exception.BookNotFoundException;
import com.example.mdb_spring_boot.api.mapper.BookMapper;
import com.example.mdb_spring_boot.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public void save(BookDto newBook) {
        Book book = bookMapper.bookEntity(newBook);
        bookRepository.save(book);
    }

    public Book update(String id, BookDto updatedBook) {
        Book book = findById(id);
        bookMapper.updateBook(updatedBook, book);
        return bookRepository.save(book);
    }

    public void delete(String id) {
        bookRepository.deleteById(id);
    }
}
