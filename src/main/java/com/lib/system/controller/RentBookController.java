package com.lib.system.controller;

import com.lib.system.entity.RentBook;
import com.lib.system.exceptions.BookAlreadyRentException;
import com.lib.system.services.RentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class RentBookController {
    RentBookService rentBookService;

    @Autowired
    public RentBookController(RentBookService rentBookService) {

        this.rentBookService = rentBookService;

    }

    @PostMapping("rent-a-book")
    public void saveRentBook(@RequestParam Map<String, String> params) throws BookAlreadyRentException {

            rentBookService.save(params);

    }
    @GetMapping("student-rent-book-list/{cnp}")
    public List<RentBook> getRentBookList(@PathVariable(value = "cnp") String cnp){

        return rentBookService.getRentBookList(cnp);
    }
    @GetMapping("student-rent-book-list-sorted-by-start-date/{cnp}")
    public List<RentBook> getRentBookListByStartDate(@PathVariable(value ="cnp") String cnp){


        return rentBookService.getRentBookListByStartDate(cnp);
    }
    @GetMapping("student-rent-book-list-sorted-by-book-title/{cnp}")
    public List<RentBook> getRentBookListByBookTitle(@PathVariable(value = "cnp") String cnp){

        return rentBookService.getRentBookListByBookTitle(cnp);
    }

    @PostMapping("return-a-book")
    public void returnAndSave(String cnp, Long bookId){

        rentBookService.returnBookToLibraryAndSave(cnp,bookId);
    }

}
