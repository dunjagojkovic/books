package com.example.demo.controller;

import com.example.demo.dto.BookDetailsDto;
import com.example.demo.dto.EditBookDetailsDto;
import com.example.demo.service.definition.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookDetailsDto dto){
        Long bookId = bookService.createBook(dto);
        return new ResponseEntity<>("Book with id: " + bookId + " created.", HttpStatus.CREATED);
    }

    @GetMapping("/{id}/book-details")
    public ResponseEntity<?> getBookInfo(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBookDetailsById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@RequestBody EditBookDetailsDto dto, @PathVariable Long id){
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

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId){
        return new ResponseEntity<>(bookService.getById(bookId), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchBooksByTitle(@RequestParam String title){
        return new ResponseEntity<>(bookService.searchByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/filter_number_of_pages")
    public ResponseEntity<?> filterBooksByNumberOfPagesBetween(@RequestParam Integer from, @RequestParam Integer to){
        return new ResponseEntity<>(bookService.filterByNumberOfPages(from, to), HttpStatus.OK);
    }
}
