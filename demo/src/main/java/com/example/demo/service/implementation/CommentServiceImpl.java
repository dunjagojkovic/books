package com.example.demo.service.implementation;

import com.example.demo.dto.AddCommentForBookDto;
import com.example.demo.dto.BookDto;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.model.Book;
import com.example.demo.model.Comment;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.definition.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final CommentMapper commentMapper;
    private final BookMapper bookMapper;

    @Override
    public Long addComment (AddCommentForBookDto dto, Long bookId) {
        Book bookToAddComment = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book with id: " + bookId + " does not exist."));
        BookDto bookDto = bookMapper.toDto(bookToAddComment);

        return commentRepository.save(commentMapper.toModel(dto,bookDto)).getId();
    }

    @Override
    public AddCommentForBookDto getById (Long id) {
        return null;
    }

    @Override
    public void deleteComment (Long id) {

    }
}
