package com.lib.system.services;

import com.lib.system.DTO.BookDTO;
import com.lib.system.entity.Book;
import com.lib.system.repositories.BookRepository;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;
    private BookDTO bookDTO;
    List<BookDTO> titleOfFoundBookDTO = new ArrayList<>();


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

    public BookDTO mapBookToBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setId(book.getId());
        bookDTO.setStock(book.getStock());
        bookDTO.setBrand(book.getBrand());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setLanguage(book.getLanguage());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setUrl(book.getUrl());
        bookDTO.setYear(book.getYear());

        return bookDTO;
    }

    public List<BookDTO> getBookByItsContent(String textToSearch) throws IOException, TikaException, InterruptedException, ExecutionException {

        List<Callable<BookDTO>> callableTasks = new ArrayList<>();
        List<Book> booksAfterUpdate = getAllBooks();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (Book book : booksAfterUpdate) {
            callableTasks.add(new Callable<BookDTO>() {
                @Override
                public BookDTO call() throws Exception {
                    return addBookToList(book, textToSearch);
                }
            });
        }

        List<Future<BookDTO>> futures = executor.invokeAll(callableTasks);

        for (Future<BookDTO> x : futures) {
            titleOfFoundBookDTO.add(x.get());
            System.out.println(x.get());
        }

        executor.shutdown();
        return titleOfFoundBookDTO;
    }

    private BookDTO addBookToList(Book book, String textToSearch) throws IOException, TikaException {
        BookDTO bookDTO = mapBookToBookDTO(book);

        Tika tikaParser = new Tika();
        tikaParser.setMaxStringLength(-1);
        Metadata metadata = new Metadata();

        byte[] decoded = book.getBookContent();
        InputStream inputStream = new ByteArrayInputStream(decoded);
        String textFromBook = tikaParser.parseToString(inputStream, metadata);
        if (textFromBook.contains(textToSearch)) {
            return bookDTO;
        } else {
            System.out.println(book.getTitle() + " nu contine " + textToSearch);
        }

        return null;

    }

}
