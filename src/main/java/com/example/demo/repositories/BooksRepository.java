package com.example.demo.repositories;

import com.example.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b where b.bookName LIKE %?1% or b.bookDesc LIKE %?1% ")
    List<Book> findByKeyWord(String searchWord);
}
