package com.example.demo.mapper;

import com.example.demo.dto.AddCommentForBookDto;
import com.example.demo.dto.BookDto;
import com.example.demo.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentMapper {

    private final BookMapper bookMapper;

    public Comment toModel(AddCommentForBookDto commentDto, BookDto bookdto){

        Comment comment = new Comment();
        comment.setId(comment.getId());
        comment.setBook(bookMapper.toModel(bookdto));
        comment.setContent(commentDto.getContent());

        return comment;
    }

    public AddCommentForBookDto toDto(Comment comment){

        AddCommentForBookDto dto = new AddCommentForBookDto();
        dto.setContent(comment.getContent());
        dto.setId(comment.getId());

        return dto;
    }

}
