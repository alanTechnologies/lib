package com.lib.system.services;

import com.lib.system.entity.Book;
import com.lib.system.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
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
}
