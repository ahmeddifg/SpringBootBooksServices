package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.entities.SearchWord;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/all")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok().body(this.bookService.getAll());
    }

    @PostMapping("/byWord/")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Book>> getAllBooksByWord(@RequestBody SearchWord word) {
        return ResponseEntity.ok().body(this.bookService.findBooksBySearchword(word.getWord()));
    }

    @RequestMapping("/{bookId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Book> getAllBooksById(@PathVariable Long bookId) {
        return ResponseEntity.ok().body(this.bookService.findOneBook(bookId));
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "*", methods = RequestMethod.POST)
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(this.bookService.addNewBook(book));
    }

    @PostMapping("/edit")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Book> editBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(this.bookService.editBook(book));
    }

    @DeleteMapping("/{bookId}")
    @CrossOrigin(origins = "*", methods = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteBook(@PathVariable Long bookId) {
        return ResponseEntity.ok().body(this.bookService.deleteBook(bookId));
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
