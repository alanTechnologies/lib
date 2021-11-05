package com.lib.system.controller;

import com.lib.system.DTO.BookDTO;
import com.lib.system.entity.Book;
import com.lib.system.repositories.BookRepository;
import com.lib.system.services.BookService;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    BookService bookService;
    BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("by-title/{title}")
    public ResponseEntity<List<Book>> getFilteredByTitleBooks(@PathVariable(value = "title") String title) {
        return new ResponseEntity<>(bookService.getFilteredByTitleBooks(title),HttpStatus.OK);
    }

    @GetMapping("by-author/{author}")
    public ResponseEntity<List<Book>> getAllBooksByAuthor(@PathVariable(value = "author") String author) {
        List<Book> list = bookService.getAllBooksByAuthor(author);
        if(list.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("by-id/{id}")
    public Book getBookById(@PathVariable(value = "id") Long id) throws IOException {
        return bookService.getBookById(id);
    }

    @GetMapping("by-paragraph/{paragraph}")
    public List<BookDTO> getBookByContent(@PathVariable(value = "paragraph") String paragraph) throws IOException, TikaException {
        return bookService.getBookByItsContent(paragraph);
    }

}
