package com.example.mdb_spring_boot.api.mapper;

import com.example.mdb_spring_boot.api.dto.BookDto;
import com.example.mdb_spring_boot.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book bookEntity(BookDto bookDto);
    void updateBook(BookDto bookDto, @MappingTarget Book book);
}