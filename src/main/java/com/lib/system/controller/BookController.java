package com.lib.system.controller;
import com.lib.system.entity.Book;
import com.lib.system.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class BookController {

    BookService bookService;
    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping("/available-books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/filtered-books-title/{title}")
    public List<Book> getFilteredByTitleBooks(@PathVariable(value = "title") String title) {
        return bookService.getFilteredByTitleBooks(title);
    }

    @GetMapping("filtered-books-author/{author}")
    public List<Book> getAllBooksByAuthor(@PathVariable(value = "author") String author) {
        return bookService.getAllBooksByAuthor(author);
    }

    @GetMapping("filtered-books-id/{id}")
    public Book getAllBookById(@PathVariable(value = "id") Long id) {
        return bookService.getAllBookById(id);
    }
}
