package com.lib.system.controller;

import com.lib.system.DTO.StudentDTO;
import com.lib.system.entity.Student;
import com.lib.system.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/by-cnp/{cnp}")
    public Student getStudentByCNP(@PathVariable(value = "cnp") String cnp) {
        return studentService.getStudentByCNP(cnp);
    }

    @PutMapping(value = "/update")
    public Student updateStudents(@RequestBody StudentDTO studentDTO) throws Exception {
        return studentService.updateStudents(studentDTO);
    }
}
