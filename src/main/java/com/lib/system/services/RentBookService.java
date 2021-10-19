package com.lib.system.services;

import com.lib.system.entity.Book;
import com.lib.system.entity.RentBook;
import com.lib.system.exceptions.BookAlreadyRentException;
import com.lib.system.repositories.BookRepository;
import com.lib.system.repositories.RentBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class RentBookService {
    private RentBookRepository rentBookRepository;
    private BookRepository bookRepository;
    private StudentService studentService;
    private RentBook rentBook;

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


    public void save(Map<String, String> params) throws BookAlreadyRentException {

        String currentCnp = params.get("cnp");
        List<RentBook> booksStudent = rentBookRepository.getAllByStudentCnp(currentCnp);

        Long currentIdBook = Long.parseLong(params.get("idBook"));

        if(rentBookContainsIdBook(booksStudent,currentIdBook)){

            throw new BookAlreadyRentException("Book already rent");

        } else
        {
            Book book = bookRepository.getById(currentIdBook);
            book.setStock(book.getStock() - 1);

            bookRepository.save(book);

            String startDay = params.get("startDay");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDayFormatted = LocalDate.parse(startDay, formatter);
            String endDay = params.get("endDay");
            LocalDate endDayFormatted = LocalDate.parse(endDay, formatter);
            String cnp = params.get("cnp");
            RentBook rentBook = createRentBook(currentIdBook, startDayFormatted, endDayFormatted, cnp);
            rentBookRepository.save(rentBook);
        }


    }

    public  boolean rentBookContainsIdBook(List<RentBook> rentBookList, Long id){

        for(RentBook rentBook:rentBookList){
            if(rentBook.getBook().getId().equals(id)){
                return true;
            }
        }
        return false;
    }

}
