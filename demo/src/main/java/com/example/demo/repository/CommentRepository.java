package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findByBook(Book book);
    Optional<Comment> findByBook_idAndId(String bookId, String commentId);
}
