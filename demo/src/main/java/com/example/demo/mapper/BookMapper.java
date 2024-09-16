package com.example.demo.mapper;

import com.example.demo.dto.BookDetailsDto;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.CommentDto;
import com.example.demo.dto.EditBookDetailsDto;
import com.example.demo.model.Book;
import com.example.demo.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookMapper {

    private final CommentMapper commentMapper;

    public BookDetailsDto convertModelToBookDetailsDto(Book book){

        BookDetailsDto dto = new BookDetailsDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setNumberOfPages(book.getNumberOfPages());
        dto.setPublishingDate(book.getPublishingDate());

        return dto;
    }

    //todo: pozivati comment mapper koji vec radi ovo, ne duplirati kod
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
