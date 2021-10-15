package com.lib.system.services;

import com.lib.system.entity.Book;
import com.lib.system.entity.RentBook;
import com.lib.system.entity.Student;
import com.lib.system.repositories.BookRepository;
import com.lib.system.repositories.RentBookRepository;
import com.lib.system.repositories.StudentRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RentBookService {
    private RentBookRepository rentBookRepository;
    private BookRepository bookRepository;
    private StudentService studentService;

    @Autowired
    public RentBookService(RentBookRepository rentBookRepository, BookRepository bookRepository, StudentService studentService) {
        this.rentBookRepository = rentBookRepository;
        this.bookRepository = bookRepository;
        this.studentService = studentService;
    }

    public RentBook createRentBook(Long idBook, LocalDate startDay, LocalDate endDay, String cnp) {
        RentBook rentBook = new RentBook();
        rentBook.setBook(bookRepository.getById(idBook));
        rentBook.setStartDate(startDay);
        rentBook.setEndDate(endDay);
        rentBook.setStudent(studentService.getStudentByCNP(cnp));

        return rentBook;
    }


    public void save(Long idBook, LocalDate startDay, LocalDate endDay, String cnp) {
    RentBook rentBook = createRentBook(idBook,startDay,endDay,cnp);

        rentBookRepository.save(rentBook);

    }


}
