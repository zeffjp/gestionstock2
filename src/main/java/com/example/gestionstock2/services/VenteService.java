package com.example.gestionstock2.services;

import com.example.gestionstock2.modele.Vente;
import com.example.gestionstock2.repositories.VenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VenteService  {
    @Autowired
    private  VenteRepository venteRepository;


    public List<Vente> getAll() {
        return venteRepository.findAll();
    }


    public Optional<Vente> getVente(UUID id) {
        return venteRepository.findById(id);
    }


    public Vente createVente(Vente vente) {
        return venteRepository.save(vente);
    }


    public void deleteById(UUID id) {
        venteRepository.deleteById(id);
    }


    public Vente update(UUID id, Vente vente) {
        // Vérification si la vente avec l'ID existe déjà dans la base de données
        Optional<Vente> existingVenteOptional = venteRepository.findById(id);
        if (existingVenteOptional.isPresent()) {
            // Mettre à jour les champs de la vente avec les nouvelles valeurs
            Vente existingVente = existingVenteOptional.get();
            existingVente.setVenteDateVente(vente.getVenteDateVente());
            existingVente.setVenteQuantiteVendue(vente.getVenteQuantiteVendue());
            existingVente.setVentePrixUnitaire(vente.getVentePrixUnitaire());
            existingVente.setVenteStatut(vente.getVenteStatut());
            existingVente.setClient(vente.getClient());

            // Enregistrer les modifications dans la base de données
            return venteRepository.save(existingVente);
        } else {
            // Si la vente n'existe pas, retourner null ou gérer l'erreur selon votre cas
            return null;
        }
    }
}
