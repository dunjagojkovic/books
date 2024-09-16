package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByTitle(String title);
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByNumberOfPagesBetween(Integer from, Integer to);
    List<Book> findByPublishingDateAfter(LocalDate date);

}
