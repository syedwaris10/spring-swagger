package com.swagger2.service;

import com.swagger2.entity.Student;
import com.swagger2.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
    }
}
