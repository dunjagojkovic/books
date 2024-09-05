package com.example.demo.controller;

import com.example.demo.dto.AddCommentForBookDto;
import com.example.demo.service.definition.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("{bookId}")
    public ResponseEntity<?> addCommentForBook(@RequestBody AddCommentForBookDto dto, @PathVariable Long bookId){
       return new ResponseEntity<>(commentService.addComment(dto, bookId), HttpStatus.CREATED);
    }
}
