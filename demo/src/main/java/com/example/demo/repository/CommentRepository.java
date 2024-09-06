package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBook(Book book);
    Optional<Comment> findByBook_idAndId(Long bookId, Long commentId);
}
