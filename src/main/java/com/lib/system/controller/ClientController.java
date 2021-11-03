package com.lib.system.controller;

import com.lib.system.entity.Client;
import com.lib.system.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public Client getClientByCnp(@PathVariable(value = "cnp") String cnp) {
        return clientService.getClientByCnp(cnp);
    }
}

