package com.lib.system.services;

import com.lib.system.entity.Client;
import com.lib.system.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ClientService {
    private ClientRepository clientRepository;
    private QRCodeGenerator qRCodeGenerator = new QRCodeGenerator();

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientByCnp(String cnp) {
        return clientRepository.getClientByCnp(cnp);
    }
}
