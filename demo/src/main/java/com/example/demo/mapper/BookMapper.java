package com.example.demo.mapper;

import com.example.demo.dto.BookDetailsDto;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.EditBookDetailsDto;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
public class BookMapper {

    @Autowired
    @Lazy
    private  CommentMapper commentMapper;

    public BookDetailsDto convertModelToBookDetailsDto(Book book){

        BookDetailsDto dto = new BookDetailsDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setNumberOfPages(book.getNumberOfPages());
        dto.setPublishingDate(book.getPublishingDate());

        return dto;
    }

    public BookDto convertModelToBookDto(Book book){

        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setNumberOfPages(book.getNumberOfPages());
        dto.setComments(commentMapper.convertModelListToCommentDtoList(book.getComments()));
        dto.setPublishingDate(book.getPublishingDate());

        return dto;
    }

    public Book convertBookDetailsDtoToModel(BookDetailsDto dto){

        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setNumberOfPages(dto.getNumberOfPages());
        book.setPublishingDate(dto.getPublishingDate());

        return book;
    }

    public Book convertBookDetailsDtoToModel(EditBookDetailsDto dto, Book bookFromDdb){

        bookFromDdb.setTitle(dto.getTitle());
        bookFromDdb.setNumberOfPages(dto.getNumberOfPages());

        return bookFromDdb;
    }


}
