package io.github.gleisonsensui.clients.rest;

import io.github.gleisonsensui.clients.model.entity.Client;
import io.github.gleisonsensui.clients.model.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public Client salvar( @RequestBody @Valid Client client) {
        return this.repository.save(client);

    }

    @GetMapping("{id}")
    public Client acharPorId(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarClient(@PathVariable Integer id) {
        repository
                .findById(id)
                .map(client -> {
                    repository.delete(client);
                return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarClient(@PathVariable Integer id, @RequestBody @Valid Client clientUpdated) {
        repository
                .findById(id)
                .map(client -> {
                    client.setName(clientUpdated.getName());
                    client.setCpf(clientUpdated.getCpf());
                    return  repository.save(client);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
