package com.lib.system.controller;

import com.lib.system.entity.Client;
import com.lib.system.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> findAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("filtered-clients-cnp/{cnp}")
    public List<Client> getAllBooksByAuthor(@PathVariable(value = "cnp") String cnp) {
        return clientService.getAllByCnp(cnp);
    }
}

