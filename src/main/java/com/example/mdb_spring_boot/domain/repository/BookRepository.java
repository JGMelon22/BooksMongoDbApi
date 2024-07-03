package com.example.mdb_spring_boot.domain.repository;

import com.example.mdb_spring_boot.domain.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
