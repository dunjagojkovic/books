package com.example.demo.service.implementation;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.EditBookDto;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.BookTitleAlreadyExistsException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.definition.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Long createBook(BookDto dto) {

        if(bookRepository.findByTitle(dto.getTitle()).isPresent()){
            throw new BookTitleAlreadyExistsException("Book with title: " + dto.getTitle() + " already exists.");
        }

        return bookRepository.save(bookMapper.toModel(dto)).getId();
    }

    @Override
    public BookDto getById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new BookNotFoundException("Book with id: " + id + " does not exist."));
    }

    @Override
    public void updateBook(Long id, EditBookDto dto) {
        bookRepository.findById(id)
                .map(bookToUpdate -> bookRepository.save(bookMapper.toModel(dto, id)))
                .orElseThrow(() -> new BookNotFoundException("Book with id: " + id + " you are trying to edit does not exist."));
    }

    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id: " + id + " you are trying to edit does not exist."));
        bookRepository.delete(book);
    }
}
