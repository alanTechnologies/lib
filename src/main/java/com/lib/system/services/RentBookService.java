package com.lib.system.services;

import com.lib.system.entity.Book;
import com.lib.system.entity.RentBook;
import com.lib.system.entity.Student;
import com.lib.system.exceptions.BookAlreadyRentException;
import com.lib.system.repositories.BookRepository;
import com.lib.system.repositories.RentBookRepository;
import com.lib.system.repositories.StudentRepository;
import liquibase.pro.packaged.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RentBookService {
    private RentBookRepository rentBookRepository;
    private BookRepository bookRepository;
    private BookService bookService;
    private StudentService studentService;
    private StudentRepository studentRepository;

    @Autowired
    public RentBookService(RentBookRepository rentBookRepository, BookRepository bookRepository, StudentService studentService, StudentRepository studentRepository, BookService bookService) {
        this.rentBookRepository = rentBookRepository;
        this.bookRepository = bookRepository;
        this.studentService = studentService;
        this.studentRepository =studentRepository;
        this.bookService = bookService;
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

    public boolean rentBookContainsIdBook(List<RentBook> rentBookList, Long id) {

        for (RentBook rentBook : rentBookList) {
            if (rentBook.getBook().getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public List<RentBook> getRentBookList(String cnp){
        return studentRepository.getStudentByCnp(cnp).getRentBook();
    }

    public List<RentBook> getRentBookListByStartDate(String cnp){
        List<RentBook> rentBookList = getRentBookList(cnp);

      return  rentBookList
                .stream()
                .sorted(Comparator.comparing(RentBook::getStartDate))
                .collect(Collectors.toList());
    }

    public List<RentBook> getRentBookListByBookTitle(String cnp){
        List<RentBook> rentBookList = getRentBookList(cnp);

        return rentBookList
                .stream()
                .sorted(Comparator.comparing(eachBook -> eachBook.getBook()
                        .getTitle()))
                .collect(Collectors.toList());

    }

    public void returnBookToLibraryAndSave( Map<String, String> params) {

        String myCnp = params.get("cnp");
        Long currentIdBook = Long.parseLong(params.get("idBook"));

        rentBookRepository.deleteByBook_IdAndStudent_Cnp(currentIdBook,myCnp);

        saveBook(currentIdBook);


    }

    public void saveBook(Long bookId){
        Book book = bookService.getBookById(bookId);
        book.setStock(book.getStock() + 1);
        bookRepository.save(book);
    }
}
