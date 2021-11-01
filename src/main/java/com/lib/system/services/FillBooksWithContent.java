package com.lib.system.services;

import com.lib.system.entity.Book;
import com.lib.system.repositories.BookRepository;
import liquibase.util.file.FilenameUtils;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FillBooksWithContent {

    BookRepository bookRepository;
    BookService bookService;

    @Autowired
    public FillBooksWithContent(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void fillBooksWithContentAndUpdate() throws IOException, TikaException {
        List<Book> books =
                bookService
                        .getAllBooks()
                        .stream()
                        .sorted(Comparator.comparing(Book::getTitle))
                        .collect(Collectors.toList());

        List<String> pathsOfBooksList =
                Files.list(Paths.get(""))
                        .filter(file -> !Files.isDirectory(file))
                        .map(Path::getFileName)
                        .map(Path::toString)
                        .filter(name -> name.endsWith(".pdf"))
                        .sorted()
                        .collect(Collectors.toList());

        Book bookToUpdate;

        for (int i = 0; i < pathsOfBooksList.size(); i++) {

            String fileNameWithoutExtension = FilenameUtils.removeExtension(pathsOfBooksList.get(i));
            String titleOfCurrentBook = books.get(i).getTitle();

            if (fileNameWithoutExtension.equals(titleOfCurrentBook)) {
                System.out.println("da");

                File convFile = new File(pathsOfBooksList.get(i));
                Path path = Path.of(convFile.getAbsolutePath());
                File pdfToSave = new File(path.toString());
                InputStream inputStream = new FileInputStream(pdfToSave);
                byte[] bytesEncoded =  inputStream.readAllBytes();

                bookToUpdate = books.get(i);
                bookToUpdate.setBookContent(bytesEncoded);
                bookRepository.save(bookToUpdate);
            }
        }

    }


}
