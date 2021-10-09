package com.lib.system.services;

import com.lib.system.entity.Client;
import com.lib.system.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public List<Client> getAllByCnp(String cnp) {
        return clientRepository.getAllByCnp(cnp);
    }
}
