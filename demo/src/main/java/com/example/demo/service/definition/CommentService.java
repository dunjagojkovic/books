package com.example.demo.service.definition;

import com.example.demo.dto.CommentDto;

import java.util.List;

public interface CommentService {

    Long addComment(CommentDto dto, Long bookId);
    CommentDto getById(Long id);
    void deleteComment(Long id);
    List<CommentDto> getAllCommentsForBook(Long bookId);
}
