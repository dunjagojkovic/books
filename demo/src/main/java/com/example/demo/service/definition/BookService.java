package com.example.demo.service.definition;

import com.example.demo.dto.BookDetailsDto;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.EditBookDetailsDto;

import java.util.List;

public interface BookService {

    Long createBook(BookDetailsDto dto);
    BookDetailsDto getBookDetailsById(Long id);
    void updateBook(Long id, EditBookDetailsDto dto);
    List<BookDetailsDto> getAll();
    void deleteBook(Long id);
    BookDto getById(Long id);
    List<BookDetailsDto> searchByTitle(String title);
    List<BookDetailsDto> filterByNumberOfPages (Integer from, Integer to);

}
