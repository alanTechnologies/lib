package com.lib.system.controller;

import com.lib.system.entity.Client;
import com.lib.system.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> findAllClients() {
        return clientService.getAllClients();
    }
}

