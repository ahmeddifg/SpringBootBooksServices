package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.entities.SearchWord;
import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/all")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok().body(this.studentService.getAll());
    }

    @PostMapping("/byWord/")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Student>> getAllStudentsByWord(@RequestBody SearchWord word) {
        return ResponseEntity.ok().body(this.studentService.findStudentBySearchword(word.getWord()));
    }

    @RequestMapping("/{studentId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        return ResponseEntity.ok().body(this.studentService.findOneStudent(studentId));
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "*", methods = RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok().body(this.studentService.addNewStudent(student));
    }

//    @PostMapping("/edit")
//    @CrossOrigin(origins = "*")
//    public ResponseEntity<Book> editBook(@RequestBody Book book) {
//        return ResponseEntity.ok().body(this.bookService.editBook(book));
//    }
//
//    @DeleteMapping("/{bookId}")
//    @CrossOrigin(origins = "*", methods = RequestMethod.DELETE)
//    public ResponseEntity<Integer> deleteBook(@PathVariable Long bookId) {
//        return ResponseEntity.ok().body(this.bookService.deleteBook(bookId));
//    }


    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
