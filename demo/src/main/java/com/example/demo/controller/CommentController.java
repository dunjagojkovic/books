package com.example.demo.controller;

import com.example.demo.dto.CommentDto;
import com.example.demo.service.definition.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/books/{bookId}/comments")
    public ResponseEntity<?> addCommentForBook(@RequestBody CommentDto dto, @PathVariable Long bookId){
       return new ResponseEntity<>(commentService.addCommentForBook(dto, bookId), HttpStatus.CREATED);
    }

    @GetMapping("/books/{bookId}/comments")
    public ResponseEntity<?> getAllCommentsForBook(@PathVariable Long bookId){
        return new ResponseEntity<>(commentService.getAllCommentsForBook(bookId), HttpStatus.OK);
    }

    @GetMapping("/books/{bookId}/comments/{commentId}")
    public ResponseEntity<?> getOneCommentForBook(@PathVariable Long bookId, @PathVariable Long commentId){
        return new ResponseEntity<>(commentService.getCommentForBookById(bookId, commentId), HttpStatus.OK);
    }


}
