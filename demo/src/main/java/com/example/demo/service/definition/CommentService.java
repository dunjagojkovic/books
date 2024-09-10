package com.example.demo.service.definition;

import com.example.demo.dto.CommentDto;

import java.util.List;

public interface CommentService {

    String addComment(CommentDto dto, String bookId);
    CommentDto getCommentForBookById(String bookId, String commentId );
    List<CommentDto> getAllCommentsForBook(String bookId);
}
