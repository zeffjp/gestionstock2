package com.example.gestionstock2.services;

import com.example.gestionstock2.modele.Client;
import com.example.gestionstock2.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientService {
    @Autowired
    private  ClientRepository clientRepository;


    public List<Client> getAll() {
        return clientRepository.findAll();
    }


    public Optional<Client> getClient(UUID id) {
        return clientRepository.findById(id);
    }


    public Client createClient(Client client) {
        return clientRepository.save(client);
    }


    public void deleteById(UUID id) {
        clientRepository.deleteById(id);
    }


    public Client update(UUID id, Client client) {
        // Vérification si le client avec l'ID existe déjà dans la base de données
        Optional<Client> existingClientOptional = clientRepository.findById(id);
        if (existingClientOptional.isPresent()) {
            // Mettre à jour les champs du client avec les nouvelles valeurs
            Client existingClient = existingClientOptional.get();
            existingClient.setClientNom(client.getClientNom());
            existingClient.setClientPrenom(client.getClientPrenom());
            existingClient.setClientEmail(client.getClientEmail());
            existingClient.setClientContact(client.getClientContact());
            existingClient.setClientTel(client.getClientTel());
            existingClient.setClientAdresse(client.getClientAdresse());

            // Enregistrer les modifications dans la base de données
            return clientRepository.save(existingClient);
        } else {
            // Si le client n'existe pas, retourner null ou gérer l'erreur selon votre cas
            return null;
        }
    }
}
