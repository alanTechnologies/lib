package com.lib.system.services;

import com.lib.system.entity.Client;
import com.lib.system.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Client getClientByEmail(String email) {
        return clientRepository.getClientByEmail(email);
    }

    public Client getClientByCnp(String cnp) {
        return clientRepository.getClientByCnp(cnp);
    }

    public void saveClient(Map<String, String> params){
        Client client = new Client();
        client.setName(params.get("name"));
        client.setAdress(params.get("adress"));
        client.setEmail(params.get("email"));

        clientRepository.save(client);
    }

}
