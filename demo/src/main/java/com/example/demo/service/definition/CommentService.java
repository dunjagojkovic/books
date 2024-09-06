package com.example.demo.service.definition;

import com.example.demo.dto.CommentDto;

import java.util.List;

public interface CommentService {

    Long addComment(CommentDto dto, Long bookId);
    CommentDto getCommentForBookById(Long bookId, Long commentId );
    List<CommentDto> getAllCommentsForBook(Long bookId);
}
