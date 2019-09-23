package com.example.demo.repositories;

import com.example.demo.entities.Book;
import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where s.studentName LIKE %?1% or s.studentId LIKE %?1% ")
    List<Student> findStudentByKeyWord(String searchWord);
}
