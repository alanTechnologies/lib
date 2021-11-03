package com.lib.system.services;

import com.lib.system.entity.Client;
import com.lib.system.repositories.ClientRepository;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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

    public Client getClientByCnp(String cnp) {
        return clientRepository.getClientByCnp(cnp);
    }

public void saveClient(Map<String,String> params){
        Client client = new Client();

        String email = params.get("email");
        String adress = params.get("adress");
        String name = params.get("name");

        client.setEmail(email);
        client.setAdress(adress);
        client.setName(name);

        clientRepository.save(client);
    }

    public Client getClientByEmail(String email){

        return clientRepository.getClientByEmail(email);
    }
}
