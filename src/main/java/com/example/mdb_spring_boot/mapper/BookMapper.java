package com.example.mdb_spring_boot.mapper;

import com.example.mdb_spring_boot.dto.BookDto;
import com.example.mdb_spring_boot.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    // BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    Book bookEntity(BookDto bookDto);
    void updateBook(BookDto bookDto, @MappingTarget Book book);
}
