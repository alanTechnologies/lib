package com.lib.system.controller;
import com.lib.system.entity.Book;
import com.lib.system.services.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class BookController {
    BookService bookService;

    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping("/available-books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

}
