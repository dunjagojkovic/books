package com.example.demo.service.definition;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.EditBookDto;

import java.util.List;

public interface BookService {

    Long createBook(BookDto dto);
    BookDto getById(Long id);
    void updateBook(Long id, EditBookDto dto);
    List<BookDto> getAll();
    void deleteBook(Long id);
}
