package com.lib.system.controller;

import com.lib.system.DTO.BookDTO;
import com.lib.system.entity.Book;
import com.lib.system.repositories.BookRepository;
import com.lib.system.services.BookService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class BookController {

    BookService bookService;
    BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
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
    public Book getBookById(@PathVariable(value = "id") Long id) throws IOException {
        return bookService.getBookById(id);
    }

    @GetMapping("shazam-book/{text}")
    public List<BookDTO> getBookByContent(@PathVariable(value = "text") String text) throws IOException, TikaException {
        return bookService.getBookByItsContent(text);
    }

}
