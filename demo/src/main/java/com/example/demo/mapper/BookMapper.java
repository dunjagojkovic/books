package com.example.demo.mapper;

import com.example.demo.dto.BookDetailsDto;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.CommentDto;
import com.example.demo.dto.EditBookDetailsDto;
import com.example.demo.model.Book;
import com.example.demo.model.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookDetailsDto toDetailsDto (Book book){

        BookDetailsDto dto = new BookDetailsDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setNumberOfPages(book.getNumberOfPages());
        dto.setPublishingDate(book.getPublishingDate());

        return dto;
    }

    public BookDto modelToDto(Book book){

        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setNumberOfPages(book.getNumberOfPages());
        dto.setComments(convertCommentToDto(book.getComments()));
        dto.setPublishingDate(book.getPublishingDate());

        return dto;
    }


    public Book toModel(BookDetailsDto dto){

        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setNumberOfPages(dto.getNumberOfPages());
        book.setPublishingDate(dto.getPublishingDate());

        return book;
    }

    public Book toModel(EditBookDetailsDto dto, Book bookFromDdb){

        bookFromDdb.setTitle(dto.getTitle());
        bookFromDdb.setNumberOfPages(dto.getNumberOfPages());

        return bookFromDdb;
    }

    private List<CommentDto> convertCommentToDto(List<Comment> comments) {
        return comments.stream()
                .map(c -> {
                    CommentDto commentDto = new CommentDto();
                    commentDto.setContent(c.getContent());
                    commentDto.setId(c.getId());
                    return commentDto;
                })
                .collect(Collectors.toList());
    }

}
