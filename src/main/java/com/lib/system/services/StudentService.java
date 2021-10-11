package com.lib.system.services;

import com.lib.system.entity.Student;
import com.lib.system.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentByCNP(String cnp){
        Student student = studentRepository.getStudentByCnp(cnp);

        if(student.getNumberOfLateReturnings() > 3){
            student.setValidForRental(false);

        }
        return student;
    }



}
