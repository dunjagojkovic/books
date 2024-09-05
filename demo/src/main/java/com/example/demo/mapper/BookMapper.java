package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.EditBookDto;
import com.example.demo.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDto toDto(Book book){

        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setNumberOfPages(book.getNumberOfPages());

        return dto;
    }

    public Book toModel(BookDto dto){

        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setNumberOfPages(dto.getNumberOfPages());

        return book;
    }

    public Book toModel(EditBookDto dto, Long id){

        Book book = new Book();
        book.setId(id);
        book.setTitle(dto.getTitle());
        book.setNumberOfPages(dto.getNumberOfPages());

        return book;
    }

}
