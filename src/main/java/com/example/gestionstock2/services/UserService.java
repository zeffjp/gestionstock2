package com.example.gestionstock2.services;

import com.example.gestionstock2.modele.User;
import com.example.gestionstock2.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService  {
    @Autowired
    private  UserRepository userRepository;


    public List<User> getAll() {
        return userRepository.findAll();
    }


    public Optional<User> getUser(UUID id) {
        return userRepository.findById(id);
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }


    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }


    public User update(UUID id, User user) {
        // Vérification si l'utilisateur avec l'ID existe déjà dans la base de données
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            // Mettre à jour les champs de l'utilisateur avec les nouvelles valeurs
            User existingUser = existingUserOptional.get();
            existingUser.setUserNom(user.getUserNom());
            existingUser.setUserPrenom(user.getUserPrenom());
            existingUser.setUserEmail(user.getUserEmail());
            existingUser.setUserMdp(user.getUserMdp());
            existingUser.setUserAdresse(user.getUserAdresse());
            existingUser.setUserContact(user.getUserContact());
            existingUser.setUserTel(user.getUserTel());

            // Enregistrer les modifications dans la base de données
            return userRepository.save(existingUser);
        } else {
            // Si l'utilisateur n'existe pas, retourner null ou gérer l'erreur selon votre cas
            return null;
        }
    }
}
