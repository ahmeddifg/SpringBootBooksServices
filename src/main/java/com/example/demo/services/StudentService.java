package com.example.demo.services;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return this.studentRepository.findAll();
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findStudentBySearchword(String word) {
        return this.studentRepository.findStudentByKeyWord(word);
    }

    public Student findOneStudent(Long studentId) {
        Optional<Student> student = this.studentRepository.findById(studentId);
        if (student.isPresent())
            return student.get();
        else return null;
    }

    public Student addNewStudent(Student student) {
        return this.studentRepository.save(student);
    }
}
