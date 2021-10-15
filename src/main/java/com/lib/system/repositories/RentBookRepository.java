package com.lib.system.repositories;

import com.lib.system.entity.RentBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentBookRepository extends JpaRepository<RentBook, Long> {
}
