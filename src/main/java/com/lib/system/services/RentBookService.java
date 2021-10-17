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
import java.time.format.DateTimeFormatter;
import java.util.Map;

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


    public void save(Map<String, String> params) {
        Long idBook = Long.parseLong(params.get("idBook"));

        String startDay = params.get("startDay");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDayFormatted = LocalDate.parse(startDay, formatter);

        String endDay = params.get("endDay");

        LocalDate endDayFormatted = LocalDate.parse(endDay, formatter);

        String cnp = params.get("cnp");


    RentBook rentBook = createRentBook(idBook,startDayFormatted,endDayFormatted,cnp);

        rentBookRepository.save(rentBook);

    }


}
