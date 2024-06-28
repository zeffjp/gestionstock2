package com.example.gestionstock2.services;

import com.example.gestionstock2.modele.Commande;
import com.example.gestionstock2.repositories.CommandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CommandeService {
    @Autowired
    private  CommandeRepository commandeRepository;


    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }


    public Optional<Commande> getCommande(UUID id) {
        return commandeRepository.findById(id);
    }


    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }


    public void deleteById(UUID id) {
        commandeRepository.deleteById(id);
    }


    public Commande update(UUID id, Commande commande) {
        // Vérification si la commande avec l'ID existe déjà dans la base de données
        Optional<Commande> existingCommandeOptional = commandeRepository.findById(id);
        if (existingCommandeOptional.isPresent()) {
            // Mettre à jour les champs de la commande avec les nouvelles valeurs
            Commande existingCommande = existingCommandeOptional.get();
            existingCommande.setCommandeDateCommande(commande.getCommandeDateCommande());
            existingCommande.setCommandeQuantiteCommandee(commande.getCommandeQuantiteCommandee());
            existingCommande.setCommandePrixUnitaire(commande.getCommandePrixUnitaire());
            existingCommande.setCommandeStatut(commande.getCommandeStatut());
            existingCommande.setClient(commande.getClient());

            // Enregistrer les modifications dans la base de données
            return commandeRepository.save(existingCommande);
        } else {
            // Si la commande n'existe pas, retourner null ou gérer l'erreur selon votre cas
            return null;
        }
    }
}
