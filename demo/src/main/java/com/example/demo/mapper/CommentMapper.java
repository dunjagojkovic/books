package com.example.demo.mapper;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.BookDetailsDto;
import com.example.demo.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentMapper {

    private final BookMapper bookMapper;

    public Comment toModel(CommentDto commentDto, BookDetailsDto bookdto){

        Comment comment = new Comment();
        comment.setId(comment.getId());
        comment.setBook(bookMapper.toModel(bookdto));
        comment.setContent(commentDto.getContent());

        return comment;
    }

    public CommentDto toDto(Comment comment){

        CommentDto dto = new CommentDto();
        dto.setContent(comment.getContent());
        dto.setId(comment.getId());

        return dto;
    }

}
