package io.github.gleisonsensui.clients.rest;

import io.github.gleisonsensui.clients.model.entity.Client;
import io.github.gleisonsensui.clients.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private  final  ClientRepository repository;

    @Autowired
    public  ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client salvar( @RequestBody Client client) {
        return this.repository.save(client);

    }
}
