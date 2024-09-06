package com.example.demo.service.implementation;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.BookDetailsDto;
import com.example.demo.exception.BookNotFoundException;
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
                .orElseThrow(() -> new BookNotFoundException("Book with id: " + bookId + " does not exist."));
        BookDetailsDto bookDetailsDto = bookMapper.toDto(bookToAddComment);

        return commentRepository.save(commentMapper.toModel(dto, bookDetailsDto)).getId();
    }

    @Override
    public CommentDto getById(Long id) {
        return null;
    }

    @Override
    public void deleteComment(Long id) {

    }

    @Override
    public List<CommentDto> getAllCommentsForBook(Long bookId) {
        Book bookToViewComments = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book with id: " + bookId + " does not exist."));
        return commentRepository.findByBook(bookToViewComments)
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }
}
