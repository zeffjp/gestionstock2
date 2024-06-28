package com.example.gestionstock2.controllers;

import com.example.gestionstock2.modele.Vente;
import com.example.gestionstock2.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/vente")
public class VenteController {
    @Autowired
    private VenteService venteService;

    @Autowired
    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @GetMapping("/read")
    public List<Vente> getAll() {
        return venteService.getAll();
    }

    @PostMapping("/create")
    public Vente create(@RequestBody Vente vente) {
        return venteService.createVente(vente);
    }

    @GetMapping("/read/{id}")
    public Optional<Vente> getById(@PathVariable UUID id) {
        return venteService.getVente(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        venteService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vente> update(@PathVariable UUID id, @RequestBody Vente vente) {
        Optional<Vente> existingVente = venteService.getVente(id);
        if (!existingVente.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        venteService.update(id, vente);
        return ResponseEntity.ok().body(vente);
    }
}
