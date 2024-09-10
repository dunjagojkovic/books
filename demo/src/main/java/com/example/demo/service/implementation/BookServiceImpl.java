package com.example.demo.service.implementation;

import com.example.demo.dto.BookDetailsDto;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.EditBookDetailsDto;
import com.example.demo.exception.BookTitleAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.definition.BookService;
import com.mongodb.MongoWriteException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public String createBook(BookDetailsDto dto) {
        try {
            return bookRepository.save(bookMapper.toModel(dto)).getId();
        } catch (DuplicateKeyException e) {
            if (e.getMessage().contains("Write operation error")) {
                throw new BookTitleAlreadyExistsException("Book with title: " + dto.getTitle() + " already exists.");
            }
            throw e;
        }
    }

    @Override
    public BookDetailsDto getBookDetailsById(String id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDetailsDto)
                .orElseThrow(() -> new EntityNotFoundException("Book with id: " + id + " does not exist."));
    }

    @Override
    public void updateBook(String id, EditBookDetailsDto dto) {
        bookRepository.findById(id)
                .map(bookToUpdate -> bookRepository.save(bookMapper.toModel(dto, bookToUpdate)))
                .orElseThrow(() -> new EntityNotFoundException("Book with id: " + id + " you are trying to edit does not exist."));
    }

    @Override
    public List<BookDetailsDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDetailsDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(String id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id: " + id + " you are trying to edit does not exist."));
        bookRepository.delete(book);
    }

    @Override
    public BookDto getById(String id) {
        return bookRepository.findById(id)
                .map(bookMapper::modelToDto)
                .orElseThrow(() -> new EntityNotFoundException("Book with id: " + id + " does not exist."));
    }

    @Override
    public List<BookDetailsDto> searchByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(bookMapper::toDetailsDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDetailsDto> filterByNumberOfPages(Integer from, Integer to) {
        return bookRepository.findByNumberOfPagesBetween(from, to)
                .stream()
                .map(bookMapper::toDetailsDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDetailsDto> filterByPublishingDate(LocalDate date) {
        return bookRepository.findByPublishingDateAfter(date)
                .stream()
                .map(bookMapper::toDetailsDto)
                .collect(Collectors.toList());
    }
}
