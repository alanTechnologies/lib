package com.lib.system.repositories;

import com.lib.system.entity.RentBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RentBookRepository extends JpaRepository<RentBook, Long> {

    List<RentBook> getAllByStudentCnp(String currentCnp);

    @Transactional
    void deleteByBook_IdAndStudent_Cnp(Long idBook,String cnp);
}
