package com.lib.system.services;

import com.lib.system.entity.Book;
import com.lib.system.entity.BoughtBook;
import com.lib.system.entity.Client;
import com.lib.system.repositories.BoughtBookRepository;
import liquibase.pro.packaged.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;

@Service
public class BoughtBookService {
    private BookService bookService;
    private ClientService clientService;
    private BoughtBookRepository boughtBookRepository;

    @Autowired
    public BoughtBookService(BoughtBookRepository boughtBookRepository, ClientService clientService, BookService bookService) {
        this.clientService = clientService;
        this.boughtBookRepository = boughtBookRepository;
        this.bookService = bookService;
    }

    public void saveBoughtBook(Map<String, String> params) {
        BoughtBook boughtBook = new BoughtBook();
        String email = params.get("email");
        Long bookId = Long.parseLong(params.get("idBook"));
        Book book = bookService.getBookById(bookId);

        boughtBook.setBook(book);
        boughtBook.setStartDate(LocalDate.now());
        boughtBook.setMaxReturnDate(LocalDate.now().plusDays(30));

        clientService.saveClient(params);

        Client client = clientService.getClientByEmail(email);
        boughtBook.setClient(client);


        boughtBookRepository.save(boughtBook);

    }

}
