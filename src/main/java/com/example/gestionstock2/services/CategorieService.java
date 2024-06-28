package com.example.gestionstock2.services;

import com.example.gestionstock2.modele.Categorie;
import com.example.gestionstock2.repositories.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategorieService  {
    @Autowired
    private  CategorieRepository categorieRepository;


    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }


    public Optional<Categorie> getCategorie(UUID id) {
        return categorieRepository.findById(id);
    }


    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }


    public void deleteById(UUID id) {
        categorieRepository.deleteById(id);
    }


    public Categorie update(UUID id, Categorie categorie) {
        // Vérification si la catégorie avec l'ID existe déjà dans la base de données
        Optional<Categorie> existingCategorieOptional = categorieRepository.findById(id);
        if (existingCategorieOptional.isPresent()) {
            // Mettre à jour les champs de la catégorie avec les nouvelles valeurs
            Categorie existingCategorie = existingCategorieOptional.get();
            existingCategorie.setCategorieNom(categorie.getCategorieNom());
            existingCategorie.setCategorieDescription(categorie.getCategorieDescription());

            // Enregistrer les modifications dans la base de données
            return categorieRepository.save(existingCategorie);
        } else {
            // Si la catégorie n'existe pas, retourner null ou gérer l'erreur selon votre cas
            return null;
        }
    }
}
