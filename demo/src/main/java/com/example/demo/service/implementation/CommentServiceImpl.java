package com.example.demo.service.implementation;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.BookDetailsDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.definition.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final CommentMapper commentMapper;
    private final BookMapper bookMapper;

    @Override
    public Long addComment(CommentDto dto, Long bookId) {
        Book bookToAddComment = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book with id: " + bookId + " does not exist."));
        BookDetailsDto bookDetailsDto = bookMapper.toDetailsDto(bookToAddComment);

        return commentRepository.save(commentMapper.toModel(dto, bookDetailsDto)).getId();
    }

    @Override
    public CommentDto getCommentForBookById(Long bookId, Long commentId) {
        Book bookToViewComment = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book with id: " + bookId + " does not exist."));

        return commentRepository.findByBook_idAndId(bookToViewComment.getId(), commentId)
                .map(commentMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Comment with id: " + commentId + " does not exist."));
    }

    @Override
    public List<CommentDto> getAllCommentsForBook(Long bookId) {
        Book bookToViewComments = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book with id: " + bookId + " does not exist."));
        return commentRepository.findByBook(bookToViewComments)
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }
}
