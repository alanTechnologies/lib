package com.lib.system.services;

import com.lib.system.DTO.StudentDTO;
import com.lib.system.entity.Student;
import com.lib.system.repositories.StudentRepository;
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

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByCNP(String cnp) {
        Student student = studentRepository.getStudentByCnp(cnp);

        if (student != null) {
            if (student.getNumberOfLateReturnings() > 3)
                student.setValidForRental(false);
        }
        return student;
    }

    public Student updateStudents(StudentDTO studentDTO) throws Exception {
        Student student = getLastStudent(studentDTO.getId()).orElseThrow(()
                -> new Exception("No student found!"));

        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setCnp(studentDTO.getCnp());
        student.setGenre(studentDTO.getGenre());
        student.setUniversity(studentDTO.getUniversity());
        student.setNumberOfLateReturnings(studentDTO.getNumberOfLateReturnings());
        student.setValidForRental(studentDTO.isValidForRental());

        return studentRepository.save(student);
    }

    public Optional<Student> getLastStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);

        if (student.isEmpty()) {
            return Optional.empty();
        }
        return student;
    }
}
