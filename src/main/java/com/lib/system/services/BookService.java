package com.lib.system.services;

import com.lib.system.entity.Book;
import com.lib.system.repositories.BookRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public boolean containsTitleIgnoreCase(Book book, String title) {
        return book.getTitle().toLowerCase(Locale.ROOT).contains(title.toLowerCase(Locale.ROOT));
    }

    public List<Book> getFilteredByTitleBooks(String title) {
        return bookRepository
                .findAll()
                .stream()
                .filter(eachBook -> containsTitleIgnoreCase(eachBook, title))
                .collect(Collectors.toList());
    }

    public List<Book> getAllBooksByAuthor(String author) {
        return bookRepository.getAllByAuthorContainingIgnoreCase(author);
    }

    public Book getBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElseThrow();
    }

    public List<Book> getBookByItsContent(String textToSearch) throws IOException, TikaException {

        List<Book> titleOfFoundBook = new ArrayList<>();
        Tika tikaParser = new Tika();
        tikaParser.setMaxStringLength(-1);
        Metadata metadata = new Metadata();

        List<Book> booksAfterUpdate = getAllBooks();
        for (Book book : booksAfterUpdate) {

            byte[] decoded = Base64.getDecoder().decode(book.getBookContent());
            InputStream inputStream = new ByteArrayInputStream(decoded);
            String textFromBook = tikaParser.parseToString(inputStream, metadata);
            if (textFromBook.contains(textToSearch)) {
                titleOfFoundBook.add(book);
            } else {
                System.out.println(book.getTitle() + " nu contine " + textToSearch);
            }

        }

        System.out.println(titleOfFoundBook.size());
        return titleOfFoundBook;
    }

}
