package com.lib.system.controller;

import com.lib.system.entity.Book;
import com.lib.system.repositories.BookRepository;
import com.lib.system.services.BookService;
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
import java.util.Locale;
import java.util.Objects;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class BookController {

    BookService bookService;
    BookRepository bookRepository;
    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository)
    {
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

    @PostMapping("save-book")
    public void saveBook(@RequestParam("file")MultipartFile file) throws IOException {


        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        Path path = Path.of(convFile.getAbsolutePath());
        File pdfToSave = new File(path.toString());

        PDDocument pdDoc = PDDocument.load(pdfToSave);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String parsedText = pdfStripper.getText(pdDoc);
        System.out.println(Arrays.toString(parsedText.trim().split("\t")));

        InputStream inputStream = new FileInputStream(pdfToSave);
        byte[] bytes = inputStream.readAllBytes();

        Book book = new Book();
        book.setBookContent(bytes);
        bookRepository.save(book);

    }
}
