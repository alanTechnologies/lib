package com.lib.system.repositories;

import com.lib.system.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> getAllByAuthorContainingIgnoreCase(String author);
}
