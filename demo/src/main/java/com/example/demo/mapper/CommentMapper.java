package com.example.demo.mapper;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.BookDetailsDto;
import com.example.demo.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CommentMapper {

    private final BookMapper bookMapper;

    public Comment convertCommentDtoToModel(CommentDto commentDto, BookDetailsDto bookDto){

        Comment comment = new Comment();
        comment.setId(comment.getId());
        comment.setBook(bookMapper.convertBookDetailsDtoToModel(bookDto));
        comment.setContent(commentDto.getContent());

        return comment;
    }

    public CommentDto convertModelToCommentDto(Comment comment){

        CommentDto dto = new CommentDto();
        dto.setContent(comment.getContent());
        dto.setId(comment.getId());

        return dto;
    }

    public List<CommentDto> convertModelListToCommentDtoList(List<Comment> comments) {
        return comments.stream()
                .map(this::convertModelToCommentDto)
                .collect(Collectors.toList());
    }

}
