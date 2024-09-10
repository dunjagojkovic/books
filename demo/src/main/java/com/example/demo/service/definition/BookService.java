package com.example.demo.service.definition;

import com.example.demo.dto.BookDetailsDto;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.EditBookDetailsDto;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    String createBook(BookDetailsDto dto);
    BookDetailsDto getBookDetailsById(String id);
    void updateBook(String id, EditBookDetailsDto dto);
    List<BookDetailsDto> getAll();
    void deleteBook(String id);
    BookDto getById(String id);
    List<BookDetailsDto> searchByTitle(String title);
    List<BookDetailsDto> filterByNumberOfPages (Integer from, Integer to);
    List<BookDetailsDto> filterByPublishingDate(LocalDate date);

}
