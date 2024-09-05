package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.EditBookDto;
import com.example.demo.service.definition.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookDto dto){
        Long bookId = bookService.createBook(dto);
        return new ResponseEntity<>("Book with id: " + bookId + " created.", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookInfo(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@RequestBody EditBookDto dto, @PathVariable Long id){
        bookService.updateBook(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks(){
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
