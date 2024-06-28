package com.example.gestionstock2.controllers;

import com.example.gestionstock2.modele.Categorie;
import com.example.gestionstock2.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/categorie")
@CrossOrigin(origins = "http://localhost:5173")
public class CategorieController {
    @Autowired
    private  CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/read")
    public List<Categorie> getAll() {
        return categorieService.getAll();
    }

    @PostMapping("/create")
    public Categorie create(@RequestBody Categorie categorie) {
        return categorieService.createCategorie(categorie);
    }

    @GetMapping("/read/{id}")
    public Optional<Categorie> getById(@PathVariable UUID id) {
        return categorieService.getCategorie(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        categorieService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Categorie> update(@PathVariable UUID id, @RequestBody Categorie categorie) {
        Optional<Categorie> existingCategorie = categorieService.getCategorie(id);
        if (!existingCategorie.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        categorieService.update(id, categorie);
        return ResponseEntity.ok().body(categorie);
    }
}
