package com.example.demo.service.definition;

import com.example.demo.dto.AddCommentForBookDto;

public interface CommentService {

    Long addComment(AddCommentForBookDto dto, Long bookId);
    AddCommentForBookDto getById(Long id);
    void deleteComment(Long id);
}
