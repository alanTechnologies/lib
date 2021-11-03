package com.lib.system.repositories;

import com.lib.system.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client getClientByEmail(String email);
    Client getClientByCnp(String cnp);

}
