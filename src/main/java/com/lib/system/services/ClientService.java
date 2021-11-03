package com.lib.system.services;

import com.google.zxing.WriterException;
import com.lib.system.entity.Client;
import com.lib.system.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

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

    @PostConstruct
    public void generateQrCodeForBook() throws IOException, WriterException {
        qRCodeGenerator.generateQRCodeImage("test3", 350, 350, "./src/main/resources/QRCode.png");
    }
}
