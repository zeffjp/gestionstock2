package com.example.gestionstock2.controllers;

import com.example.gestionstock2.modele.Commande;
import com.example.gestionstock2.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/read")
    public List<Commande> getAll() {
        return commandeService.getAll();
    }

    @PostMapping("/create")
    public Commande create(@RequestBody Commande commande) {
        return commandeService.createCommande(commande);
    }

    @GetMapping("/read/{id}")
    public Optional<Commande> getById(@PathVariable UUID id) {
        return commandeService.getCommande(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        commandeService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Commande> update(@PathVariable UUID id, @RequestBody Commande commande) {
        Optional<Commande> existingCommande = commandeService.getCommande(id);
        if (!existingCommande.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        commandeService.update(id, commande);
        return ResponseEntity.ok().body(commande);
    }
}
