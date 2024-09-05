package com.example.demo.repository;

import com.example.demo.dto.CommentDto;
import com.example.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<CommentDto> findByBookId(Long bookId);
}
