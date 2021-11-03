package com.lib.system.repositories;

import com.lib.system.entity.BoughtBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtBookRepository extends JpaRepository<BoughtBook, Long> {

}
