package com.example.gestionstock2.controllers;

import com.example.gestionstock2.modele.Client;
import com.example.gestionstock2.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private  ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/read")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @PostMapping("/create")
    public Client create(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/read/{id}")
    public Optional<Client> getById(@PathVariable UUID id) {
        return clientService.getClient(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        clientService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> update(@PathVariable UUID id, @RequestBody Client client) {
        Optional<Client> existingClient = clientService.getClient(id);
        if (!existingClient.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        clientService.update(id, client);
        return ResponseEntity.ok().body(client);
    }
}
