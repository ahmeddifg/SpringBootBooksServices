package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BooksRepository booksRepository;

    @Autowired
    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAll() {
        return this.booksRepository.findAll();
    }

    public List<Book> findBooksBySearchword(String searchword) {
       return this.booksRepository.findByKeyWord(searchword);
    }

    public Book findOneBook(Long id) {
        Optional<Book> book = null;
        book = this.booksRepository.findById(id);
        if (book.isPresent())
            return book.get();
        else return null;
    }

    public Book addNewBook(Book book) {
        return this.booksRepository.save(book);
    }

    public Book editBook(Book book) {
        return this.booksRepository.save(book);
    }

    public Integer deleteBook(Long bookId) {
        this.booksRepository.deleteById(bookId);
        return new Integer(0);
    }


    public BooksRepository getBooksRepository() {
        return booksRepository;
    }

    public void setBooksRepository(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
}
